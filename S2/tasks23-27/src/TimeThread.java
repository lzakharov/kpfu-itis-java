import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by lzakharov on 10.05.15.
 */
public class TimeThread implements Runnable{
    String city;
    String timeZone;

    public TimeThread(String city, String timeZone) {
        this.city = city;
        this.timeZone = timeZone;
    }

    @Override
    public void run() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
        while (true) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            System.out.println(city + ": " + dateFormat.format(calendar.getTime()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
