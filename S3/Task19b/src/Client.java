import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lzakharov on 02.11.15.
 */
public class Client {
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
        String host = "localhost";
        Socket socket = new Socket(host, PORT);
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        while (true) {
            String x = in.readLine();
            markCity(x);
            System.out.println("Server: " + x);
            System.out.println(">");

            boolean correctCity = false;
            while (!correctCity) {
                String y = scanner.nextLine();
                if (isSuitable(y)) {
                    correctCity = true;
                    markCity(y);
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
