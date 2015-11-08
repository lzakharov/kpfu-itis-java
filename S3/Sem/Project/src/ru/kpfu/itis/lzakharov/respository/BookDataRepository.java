package ru.kpfu.itis.lzakharov.respository;

import ru.kpfu.itis.lzakharov.models.BookData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 02.11.15.
 */
public class BookDataRepository extends Repository {
    public static BookData getBookDataByBookId(int id) {
        BookData bookData = null;

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"BOOK_DATA\" WHERE book_id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                bookData = new BookData(id, result.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookData;
    }
}
