package ru.kpfu.itis.lzakharov.net.packet;

/**
 * Created by lzakharov on 16.11.15.
 */

public enum PacketType {
    INVALID(-1), LOGIN(0), DISCONNECT(1), MOVE(2), SHOOT(3);

    private int id;

    PacketType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
