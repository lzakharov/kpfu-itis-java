package ru.kpfu.itis.lzakharov.respository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 02.11.15.
 */
public class BookAuthorRepository extends Repository {
    public static String getAuthorsByBookId(int id) {
        String authors = "";

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT array_to_string(array_agg(\"AUTHOR\".name), ', ') AS authors\n" +
                    "FROM \"BOOK_AUTHOR\", \"BOOK\", \"AUTHOR\"\n" +
                    "WHERE \"BOOK\".book_id = \"BOOK_AUTHOR\".book_id\n" +
                    "  AND \"AUTHOR\".author_id = \"BOOK_AUTHOR\".author_id\n" +
                    "  AND \"BOOK\".book_id = " + id + "\n" +
                    "GROUP BY \"BOOK\".name;");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                authors = result.getString("authors");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }
}
