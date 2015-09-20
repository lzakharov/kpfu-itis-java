import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lzakharov on 10.05.15.
 */
public class b28 {
    public static void main(String[] args) {
        int[] data;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            int k = Integer.parseInt(bufferedReader.readLine());
            String[] t = bufferedReader.readLine().split(" ");
            data = new int[t.length];

            for (int i = 0; i < t.length; i++) {
                data[i] = Integer.parseInt(t[i]);
            }

            for (int i = 0; i < k; i++) {
                Thread thread = new Thread(new SumThread(data, i * k, Math.min((i + 1) * k, data.length)));
                thread.start();
                thread.join();
            }

            new SumThread(data, 0, data.length).printSum();

        } catch (IOException e) {
        } catch (InterruptedException e) {
        }
    }
}
