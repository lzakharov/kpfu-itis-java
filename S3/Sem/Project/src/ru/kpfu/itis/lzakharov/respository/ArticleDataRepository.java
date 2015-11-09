package ru.kpfu.itis.lzakharov.respository;

import ru.kpfu.itis.lzakharov.models.ArticleData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
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
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"ARTICLE_DATA\" WHERE article_id = " + article_id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                articleData = new ArticleData(result.getInt("article_id"), result.getBlob("image"), result.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articleData;
    }

    public static void addArticleData(int article_id, String text, File blob) {
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("INSERT INTO \"ARTICLE_DATA\" " +
                            "VALUES(?, ?, ?)"
            );

            FileInputStream in = new FileInputStream(blob);
            statement.setInt(1, article_id);
            statement.setBinaryStream(2, in, (int)blob.length());
            statement.setString(3, text);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
