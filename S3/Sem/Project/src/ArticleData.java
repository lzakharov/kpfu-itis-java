import java.sql.Blob;

/**
 * Created by lzakharov on 20.10.15.
 */
public class ArticleData {
    private int article_id;
    private Blob image;
    private String text;

    public ArticleData(int article_id, Blob image, String text) {
        this.article_id = article_id;
        this.image = image;
        this.text = text;
    }

    public Blob getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
