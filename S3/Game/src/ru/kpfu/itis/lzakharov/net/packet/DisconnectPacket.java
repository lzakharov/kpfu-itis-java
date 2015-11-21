package ru.kpfu.itis.lzakharov.net.packet;

/**
 * Created by lzakharov on 16.11.15.
 */

public class DisconnectPacket extends Packet {
    private String username;

    public DisconnectPacket(byte[] data) {
        super(1);
        String[] dataArray = readData(data).split(",");
        this.username = dataArray[0];
    }

    public DisconnectPacket(String username) {
        super(1);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public byte[] getData() {
        return ("1" + username).getBytes();
    }
}

