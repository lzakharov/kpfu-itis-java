package ru.kpfu.itis.lzakharov.net.packet;

/**
 * Created by lzakharov on 16.11.15.
 */

public class MovePacket extends Packet {
    private String username;
    private int x, y;
    private int direction;

    public MovePacket(byte[] data) {
        super(0);
        String[] dataArray = readData(data).split(",");
        this.username = dataArray[0];
        this.x = Integer.parseInt(dataArray[1]);
        this.y = Integer.parseInt(dataArray[2]);
        this.direction = Integer.parseInt(dataArray[3]);
    }

    public MovePacket(String username, int x, int y, int direction) {
        super(0);
        this.username = username;
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    @Override
    public byte[] getData() {
        return ("0" + this.username + "," + this.x + "," + this.y + "," + this.direction).getBytes();
    }
}

