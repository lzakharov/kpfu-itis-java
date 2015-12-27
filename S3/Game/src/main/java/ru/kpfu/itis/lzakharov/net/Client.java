package ru.kpfu.itis.lzakharov.net;

import ru.kpfu.itis.lzakharov.game.Controller;
import ru.kpfu.itis.lzakharov.game.Game;
import ru.kpfu.itis.lzakharov.game.entity.Bullet;
import ru.kpfu.itis.lzakharov.game.entity.Player;
import ru.kpfu.itis.lzakharov.game.entity.PlayerMP;
import ru.kpfu.itis.lzakharov.net.packet.*;

import java.io.IOException;
import java.net.*;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Client implements Runnable {

    private Game game;
    private int port;
    private InetAddress inetAddress;
    private DatagramSocket socket;
    private Thread thread;

    public Client(Game game, int port, String inetAddress) {
        this.game = game;
        this.port = port;

        try {
            this.socket = new DatagramSocket();
            this.inetAddress = InetAddress.getByName(inetAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        this.thread = new Thread(this);
        this.thread.start();
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
                handleLogin(loginPacket, packet.getAddress(), packet.getPort());
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
                Controller.getController().removePlayer(disconnectPacket.getUsername());
                game.showMessage("User " + disconnectPacket.getUsername() + " left the game:(");
                break;
        }
    }

    public void sendData(byte[] data) {
        DatagramPacket packet = new DatagramPacket(data, data.length, inetAddress, port);

        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleLogin(LoginPacket packet, InetAddress inetAddress, int port) {
        Player player = new PlayerMP(game, packet.getUsername(), game.getMPatlas(), packet.getX(), packet.getY(), inetAddress, port);
        Controller.getController().addEntity(player);
    }

    private void handleMove(MovePacket packet) {
        Controller.getController().movePlayer(packet.getUsername(), packet.getX(), packet.getY(), packet.getDirection());
    }

    private void handleShoot(ShootPacket shootPacket) {
        Controller.getController().shoot(new Bullet(shootPacket.getUsername(), shootPacket.getX(), shootPacket.getY(), shootPacket.getDirection(), shootPacket.getSpeed()));
    }
}