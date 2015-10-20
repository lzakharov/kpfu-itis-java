import javax.swing.text.html.HTMLDocument;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 20.10.15.
 */
public class ArticleDataRepository extends Repository {
    public static ArticleData getArticleDataById(int article_id) {
        ArticleData articleData = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ARTICLE_DATA WHERE article_id = " + article_id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                articleData = new ArticleData(result.getInt("article_id"), result.getBlob("image"), result.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articleData;
    }
}
