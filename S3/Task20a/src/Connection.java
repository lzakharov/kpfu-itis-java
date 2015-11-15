import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by lzakharov on 11.11.15.
 */

public class Connection implements Runnable {
    private Socket socket;
    private Thread thread;
    private Server server;
    private LinkedList<Message> messages;

    public Connection(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.messages = new LinkedList<>();
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.flush();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) ois.readObject();
                System.out.println(message);
                server.addMessage(message);

                ArrayList<Message> messagesToSend = new ArrayList<>();

                for (Message m: server.getMessages()) {
                    if (!messages.contains(m)) {
                        messages.add(m);
                        messagesToSend.add(m);
                    }
                }

                oos.writeObject(messagesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

