package ru.kpfu.itis.lzakharov.respository;

import ru.kpfu.itis.lzakharov.models.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 03.11.15.
 */
public class ReviewRepository extends Repository {
    public static LinkedList<Review> getReviewsByBookId(int id) {
        LinkedList<Review> reviews = new LinkedList<>();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"REVIEW\" WHERE book_id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                reviews.add(new Review(result.getInt("review_id"), result.getInt("book_id"), result.getInt("user_id"),
                        result.getInt("type"), result.getString("text"), result.getTimestamp("timestamp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }

    public static void addReview(int book_id, int user_id, int type, String text) {
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("INSERT INTO \"REVIEW\" " +
                    "(\"book_id\", \"user_id\", \"type\", \"text\", \"timestamp\") " +
                    "VALUES(?, ?, ?, ?, CURRENT_TIMESTAMP)");
            statement.setInt(1, book_id);
            statement.setInt(2, user_id);
            statement.setInt(3, type);
            statement.setString(4, text);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteReview(int review_id) {
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("DELETE FROM \"REVIEW\" " +
                    "WHERE review_id = ?");
            statement.setInt(1, review_id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
