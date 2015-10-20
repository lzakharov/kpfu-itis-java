import java.sql.Date;

/**
 * Created by lzakharov on 20.10.15.
 */
public class Article {
    private int id;
    private String title;
    private String author;
    private Date date;
    private String description;

    public Article(int id, String title, String author, Date date, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
