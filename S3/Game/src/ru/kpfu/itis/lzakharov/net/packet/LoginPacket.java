package ru.kpfu.itis.lzakharov.net.packet;

import ru.kpfu.itis.lzakharov.net.Client;
import ru.kpfu.itis.lzakharov.net.Server;

/**
 * Created by lzakharov on 16.11.15.
 */

public class LoginPacket extends Packet {
    private String username;
    private int x, y;

    public LoginPacket(byte[] data) {
        super(0);
        String[] dataArray = readData(data).split(",");
        this.username = dataArray[0];
        this.x = Integer.parseInt(dataArray[1]);
        this.y = Integer.parseInt(dataArray[2]);
    }

    public LoginPacket(String username, int x, int y) {
        super(0);
        this.username = username;
        this.x = x;
        this.y = y;
    }

    public String getUsername() {
        return username;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public byte[] getData() {
        return ("0" + this.username + "," + this.x + "," + this.y).getBytes();
    }
}

