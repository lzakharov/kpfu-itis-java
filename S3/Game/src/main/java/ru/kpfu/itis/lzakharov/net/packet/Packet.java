package ru.kpfu.itis.lzakharov.net.packet;

import ru.kpfu.itis.lzakharov.net.Client;
import ru.kpfu.itis.lzakharov.net.Server;

/**
 * Created by lzakharov on 15.11.15.
 */

public abstract class Packet {
    private byte id;

    public Packet(int id) {
        this.id = (byte) id;
    }

    public void writeData(Server server) {
        server.sendDataToAllClients(getData());
    };

    public void writeData(Client client) {
        client.sendData(getData());
    };

    public String readData(byte[] data) {
        String message = new String(data);
        return message.substring(1);
    }

    public abstract byte[] getData();

    public static PacketType lookupPacket(String packetId) {
        try {
            return lookupPacket(Integer.parseInt(packetId));
        } catch (NumberFormatException e) {
            return PacketType.INVALID;
        }
    }

    public static PacketType lookupPacket(int id) {
        for (PacketType p : PacketType.values()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return PacketType.INVALID;
    }
}

