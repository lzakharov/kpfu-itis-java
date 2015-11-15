import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lzakharov on 11.11.15.
 */

public class Message implements Serializable {
    private String username;
    private String message;
    private long time;

    public Message(String username, String message) {
        this.username = username;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public String getTime() {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.MILLISECONDS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)));
    }

    @Override
    public String toString() {
        return getTime() + " " + username + ": " + message;
    }
}

