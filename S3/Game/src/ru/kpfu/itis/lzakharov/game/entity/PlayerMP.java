package ru.kpfu.itis.lzakharov.game.entitie;

import ru.kpfu.itis.lzakharov.IO.KeyInput;

import java.net.InetAddress;

/**
 * Created by lzakharov on 20.11.15.
 */

public class PlayerMP extends Player {
    private InetAddress inetAddress;
    private int port;

    public PlayerMP(String username, int x, int y, InetAddress inetAddress, int port) {
        super(username, x, y, null);
        this.inetAddress = inetAddress;
        this.port = port;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public int getPort() {
        return port;
    }

}

