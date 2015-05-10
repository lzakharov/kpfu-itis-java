import java.io.*;
import java.util.Timer;

/**
 * Created by lzakharov on 07.05.15.
 */
public class с26 {
    public static void main(String[] args) throws IOException {
        long time = System.nanoTime();
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");

        int c;

        while ((c = fileReader.read()) != -1) {
            fileWriter.write(c);
        }

        fileReader.close();
        fileWriter.close();
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String s;

        while ((s = bufferedReader.readLine()) != null) {
            bufferedWriter.write(s);
        }

        bufferedReader.close();
        bufferedWriter.close();
        System.out.println(System.nanoTime() - time);

    }
}
