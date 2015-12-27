package ru.kpfu.itis.lzakharov.net.packet;

/**
 * Created by lzakharov on 16.11.15.
 */

public class MovePacket extends Packet {
    private String username;
    private int x, y;
    private int direction;

    public MovePacket(byte[] data) {
        super(2);
        String[] dataArray = readData(data).split(",");
        this.username = dataArray[0];
        this.x = Integer.parseInt(dataArray[1].trim());
        this.y = Integer.parseInt(dataArray[2].trim());
        this.direction = Integer.parseInt(dataArray[3].trim());
    }

    public MovePacket(String username, int x, int y, int direction) {
        super(2);
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
        return ("2" + this.username + "," + this.x + "," + this.y + "," + this.direction).getBytes();
    }
}

