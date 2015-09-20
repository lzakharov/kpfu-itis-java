import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by lzakharov on 14.03.15.
 */
public class Generator {
    public static void main(String[] args) {
        final Random random = new Random();

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("input.txt")));
            for (int i = 100; i < 10001; i += 50) {
                out.write(Integer.toString(i));
                out.write('\n');
                for (int j = 0; j < i; j++) {
                    out.write(Integer.toString(random.nextInt(i)) + " ");
                }
                out.write('\n');
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
