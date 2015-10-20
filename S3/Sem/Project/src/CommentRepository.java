import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 20.10.15.
 */
public class CommentRepository extends Repository {
    public static LinkedList<Comment> getComments() {
        LinkedList<Comment> comments = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM COMMENT");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                comments.add(new Comment(result.getString("author"), result.getTimestamp("time"), result.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
}
