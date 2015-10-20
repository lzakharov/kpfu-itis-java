import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by lzakharov on 20.10.15.
 */
public class Comment {
    public String author;
    public Timestamp time;
    public String text;

    public Comment(String author, Timestamp time, String text) {
        this.author = author;
        this.time = time;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}

