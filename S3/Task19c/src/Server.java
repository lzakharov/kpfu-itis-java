import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lzakharov on 02.11.15.
 */
public class Server {
    final static int PORT = 3456;
    private static String serverName;
    private static String clientName;

    private static void write(BufferedWriter out, String x) throws IOException {
        out.write(x);
        out.newLine();
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.print("Please enter your name: ");
        serverName = scanner.nextLine();
        write(out, serverName);

        clientName = in.readLine();

        while (true) {
            System.out.print(serverName + ": ");
            String x = scanner.nextLine();
            write(out, x);

            String y = in.readLine();
            System.out.println(clientName + ": " + y);
        }
    }
}
