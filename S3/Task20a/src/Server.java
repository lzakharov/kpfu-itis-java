import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by lzakharov on 11.11.15.
 */

public class Server {
    private static final int PORT = 5432;
    private LinkedList<Connection> connections;
    private LinkedList<Message> messages;

    public Server() throws IOException {
        connections = new LinkedList<>();
        messages = new LinkedList<>();

        start();
    }

    private void start() throws IOException {
        ServerSocket socket = new ServerSocket(PORT);

        while (true) {
            Socket client = socket.accept();
            System.out.println("Client connected");
            connections.add(new Connection(client, this));
        }
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

