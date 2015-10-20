import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 20.10.15.
 */
public class ArticleRepository extends Repository {
    public static LinkedList<Article> getArticles() {
        LinkedList<Article> list = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ARTICLE");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Article(result.getInt("id"), result.getString("title"),
                        result.getString("author"), result.getDate("date"),
                        result.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static Article getArticleById(int id) {
        Article article = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ARTICLE WHERE id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                article = new Article(result.getInt("id"), result.getString("title"), result.getString("author"), result.getDate("date"), result.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return article;
    }
}
