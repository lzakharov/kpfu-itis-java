package ru.kpfu.itis.lzakharov.net.packet;

/**
 * Created by lzakharov on 16.11.15.
 */

public class ShootPacket extends Packet {
    private String username;
    private int x, y;
    private int direction;
    private int speed;

    public ShootPacket(byte[] data) {
        super(3);
        String[] dataArray = readData(data).split(",");
        this.username = dataArray[0];
        this.x = Integer.parseInt(dataArray[1].trim());
        this.y = Integer.parseInt(dataArray[2].trim());
        this.direction = Integer.parseInt(dataArray[3].trim());
        this.speed = Integer.parseInt(dataArray[4].trim());
    }

    public ShootPacket(String username, int x, int y, int direction, int speed) {
        super(3);
        this.username = username;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
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

    public int getSpeed() {
        return speed;
    }

    @Override
    public byte[] getData() {
        return ("3" + this.username + "," + this.x + "," + this.y + "," + this.direction + "," + this.getSpeed()).getBytes();
    }
}

