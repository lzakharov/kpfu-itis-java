package ru.kpfu.itis.lzakharov.respository;

import ru.kpfu.itis.lzakharov.models.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 20.10.15.
 */
public class CommentRepository extends Repository {
    public static LinkedList<Comment> getCommentsByArticleId(int id) {
        LinkedList<Comment> comments = new LinkedList<>();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"COMMENT\" WHERE article_id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                comments.add(new Comment(result.getInt("comment_id"), result.getInt("article_id"),
                        result.getInt("author_id"), result.getString("text"), result.getTimestamp("timestamp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public static void addComment(int article_id, int author_id, String text) {
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("INSERT INTO \"COMMENT\" " +
                    "(\"article_id\", \"author_id\", \"text\", \"timestamp\")" +
                    "VALUES (?, ?, ?, CURRENT_TIMESTAMP)");
            statement.setInt(1, article_id);
            statement.setInt(2, author_id);
            statement.setString(3, text);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteComment(int comment_id) {
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("DELETE FROM \"COMMENT\" " +
                    "WHERE comment_id = ?");
            statement.setInt(1, comment_id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
