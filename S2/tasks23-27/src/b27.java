import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lzakharov on 09.05.15.
 */
public class b27 {
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("cities.in"));
            int n = Integer.parseInt(bufferedReader.readLine()) + 1;
            String city;
            String timeZoneID;
            Thread[] timeThreads = new Thread[n];
            int k = 0;

            while ((city = bufferedReader.readLine()) != null) {
                timeZoneID = bufferedReader.readLine();
                timeThreads[k] = new Thread(new TimeThread(city, timeZoneID));
                k++;
            }

            for (int i = 0; i < n - 1; i++) {
                timeThreads[i].start();
            }

        } catch (IOException e) {
        }

    }
}
