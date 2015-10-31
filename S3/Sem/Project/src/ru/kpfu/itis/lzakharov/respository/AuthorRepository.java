package ru.kpfu.itis.lzakharov.respository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lzakharov on 26.10.15.
 */
public class AuthorRepository extends Repository {
    public static String getNameById(int id) {
        String name = null;

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT name FROM AUTHOR WHERE author_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }
}
