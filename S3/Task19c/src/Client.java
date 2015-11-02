import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lzakharov on 02.11.15.
 */
public class Client {
    final static int PORT = 3456;
    private static String serverName;
    private static String clientName;

    private static void write(BufferedWriter out, String x) throws IOException {
        out.write(x);
        out.newLine();
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        Socket socket = new Socket(host, PORT);
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        serverName = in.readLine();
        System.out.print("Please enter your name: ");
        clientName = scanner.nextLine();
        write(out, clientName);

        while (true) {
            String y = in.readLine();
            System.out.println(serverName + ": " + y);

            System.out.print(clientName + ": ");
            String x = scanner.nextLine();
            write(out, x);
        }
    }
}
