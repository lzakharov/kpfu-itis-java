package ru.kpfu.itis.lzakharov.net;

import ru.kpfu.itis.lzakharov.game.Controller;
import ru.kpfu.itis.lzakharov.game.Game;
import ru.kpfu.itis.lzakharov.game.entity.PlayerMP;
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

    private Game game;
    private DatagramSocket socket;
    private LinkedList<PlayerMP> connectedPlayers;
    private Thread thread;

    public Server(Game game, int port) throws SocketException {
        this.game = game;
        this.connectedPlayers = new LinkedList<>();

        this.socket = new DatagramSocket(port);

        this.thread = new Thread(this);
        this.thread.start();
    }

    public void addPlayer(PlayerMP player, LoginPacket packet) {
        boolean alreadyConnected = false;
        for (PlayerMP playerMP : connectedPlayers) {
            if (player.getUsername().equalsIgnoreCase(playerMP.getUsername())) {
                if (playerMP.getInetAddress() == null) {
                    playerMP.setInetAddress(player.getInetAddress());
                }
                if (playerMP.getPort() == -1) {
                    playerMP.setPort(player.getPort());
                }
                alreadyConnected = true;
            } else {
                sendData(packet.getData(), playerMP.getInetAddress(), playerMP.getPort());

                packet = new LoginPacket(playerMP.getUsername(), playerMP.getX(), playerMP.getY());
                sendData(packet.getData(), player.getInetAddress(), player.getPort());
            }
        }
        if (!alreadyConnected && this.connectedPlayers.size() < 2) {
            this.connectedPlayers.add(player);
        }

        if (this.connectedPlayers.size() == 2) {

            game.start();
        }
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
                System.out.println("Player " + loginPacket.getUsername() + " connected");
                addPlayer(new PlayerMP(game, loginPacket.getUsername(), game.getMPatlas(), loginPacket.getX(), loginPacket.getY(),
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

