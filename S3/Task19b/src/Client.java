import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lzakharov on 02.11.15.
 */
public class Client {
    final static int PORT = 3456;

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        Socket socket = new Socket(host, PORT);
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        while (true) {
            String x = in.readLine();
            Server.markCity(x);
            System.out.println("Server: " + x);
            System.out.println(">");

            boolean correctCity = false;
            while (!correctCity) {
                String y = scanner.nextLine();
                if (Server.isSuitable(y)) {
                    correctCity = true;
                    Server.markCity(y);
                    out.write(y);
                    out.newLine();
                    out.flush();
                } else {
                    System.out.println("Please, write another city:");
                }
            }
        }
    }
}
