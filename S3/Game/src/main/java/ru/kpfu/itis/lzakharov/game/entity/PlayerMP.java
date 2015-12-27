package ru.kpfu.itis.lzakharov.game.entity;

import ru.kpfu.itis.lzakharov.game.$Map;
import ru.kpfu.itis.lzakharov.game.Game;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;

import java.net.InetAddress;

/**
 * Created by lzakharov on 20.11.15.
 */

public class PlayerMP extends Player {
    private InetAddress inetAddress;
    private int port;

    public PlayerMP(Game game, String username, TextureAtlas atlas, int x, int y, InetAddress inetAddress, int port) {
        super(game, username, atlas, x, y, null, null);
        this.inetAddress = inetAddress;
        this.port = port;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

