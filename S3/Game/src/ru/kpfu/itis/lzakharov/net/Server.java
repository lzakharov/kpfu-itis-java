package ru.kpfu.itis.lzakharov.net;

import ru.kpfu.itis.lzakharov.game.Game;
import ru.kpfu.itis.lzakharov.game.entitie.PlayerMP;
import ru.kpfu.itis.lzakharov.net.packet.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Server implements Runnable {
    private static final int PORT = 8765;

    private DatagramSocket socket;
    private LinkedList<PlayerMP> connectedPlayers;
    private Thread thread;

    public Server() {
        this.connectedPlayers = new LinkedList<>();

        try {
            this.socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        this.thread = new Thread(this);
        this.thread.start();
    }

    public void addPlayer(PlayerMP player, LoginPacket packet) {
        // TODO: check if player already connected
        connectedPlayers.add(player);
        sendDataToAllClients(packet.getData());
    }

    public void removePlayer(DisconnectPacket disconnectPacket) {
        try {
            connectedPlayers.remove(getPlayerIndex(disconnectPacket.getUsername()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        disconnectPacket.writeData(this);
    }

    private int getPlayerIndex(String username) {
        for (int i = 0; i < connectedPlayers.size(); i++) {
            if (connectedPlayers.get(i).getUsername().equals(username)) {
                return i;
            }
        }

        return -1;
    }

    private PlayerMP getPlayer(String username) {
        for (PlayerMP player : connectedPlayers) {
            if (player.getUsername().equals(username)) {
                return player;
            }
        }

        return null;
    }

    @Override
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);

            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            parsePacket(packet);
        }
    }

    private void parsePacket(DatagramPacket packet) {
        String message = new String(packet.getData());
        PacketType type = Packet.lookupPacket(message.substring(0, 1));

        switch (type) {
            case INVALID:
                break;
            case LOGIN:
                LoginPacket loginPacket = new LoginPacket(packet.getData());
                addPlayer(new PlayerMP(loginPacket.getUsername(), loginPacket.getX(), loginPacket.getY(),
                        packet.getAddress(), packet.getPort()), loginPacket);
                break;
            case MOVE:
                MovePacket movePacket = new MovePacket(packet.getData());
                handleMove(movePacket);
                break;
            case SHOOT:
                ShootPacket shootPacket = new ShootPacket(packet.getData());
                handleShoot(shootPacket);
                break;
            case DISCONNECT:
                DisconnectPacket disconnectPacket = new DisconnectPacket(packet.getData());
                this.removePlayer(disconnectPacket);
                break;
        }
    }

    private void handleShoot(ShootPacket shootPacket) {
        if (getPlayer(shootPacket.getUsername()) != null) {
            shootPacket.writeData(this);
        }
    }

    private void handleMove(MovePacket movePacket) {
        if (getPlayer(movePacket.getUsername()) != null) {
            PlayerMP player = getPlayer(movePacket.getUsername());
            player.setCoordinates(movePacket.getX(), movePacket.getY());
            movePacket.writeData(this);
        }
    }

    public void sendData(byte[] data, InetAddress inetAddress, int port) {
        DatagramPacket packet = new DatagramPacket(data, data.length, inetAddress, port);

        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendDataToAllClients(byte[] data) {
        for (PlayerMP player : connectedPlayers) {
            sendData(data, player.getInetAddress(), player.getPort());
        }
    }
}

