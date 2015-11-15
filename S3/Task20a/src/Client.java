import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lzakharov on 11.11.15.
 */

public class Client {
    private static final int PORT = 5432;
    private static final String HOST = "localhost";

    private int port;
    private String host;
    private Socket socket;
    private String username;

    public Client() {
        this.port = PORT;
        this.host = HOST;
        try {
            this.socket = new Socket(host, port);
            Scanner scanner = new Scanner(System.in);
            username = scanner.nextLine();

            while (true) {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.flush();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                oos.writeObject(new Message(username, scanner.nextLine()));

                ArrayList<Message> messages = (ArrayList<Message>) ois.readObject();
                for (Message message: messages) {
                    System.out.println(message);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}

