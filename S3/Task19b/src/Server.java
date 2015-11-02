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
    private static LinkedList<String> list = new LinkedList<>();

    public static void markCity(String city) {
        list.add(city);
    }

    public static boolean isCorrectLettersCase(String city) {
        Pattern pattern = Pattern.compile("\\p{Upper}(\\p{Lower})+");
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    public static boolean isSuitable(String city) {
        if (list.isEmpty()) {
            return true;
        } else {
            char lastLetter = list.getLast().charAt(list.getLast().length() - 1);
            return (isCorrectLettersCase(city) &&
                    Character.isUpperCase(city.charAt(0))
                    && !list.contains(city)
                    && lastLetter == Character.toLowerCase(city.charAt(0))
            );
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        while (true) {
            System.out.println(">");

            boolean correctCity = false;
            while (!correctCity) {
                String x = scanner.nextLine();
                if (Server.isSuitable(x)) {
                    correctCity = true;
                    Server.markCity(x);
                    out.write(x);
                    out.newLine();
                    out.flush();
                } else {
                    System.out.println("Please, write another city:");
                }
            }

            String y = in.readLine();
            markCity(y);
            System.out.println("Client: " + y);

        }
    }
}
