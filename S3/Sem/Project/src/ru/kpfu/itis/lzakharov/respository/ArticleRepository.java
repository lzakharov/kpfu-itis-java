package ru.kpfu.itis.lzakharov.respository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.kpfu.itis.lzakharov.models.Article;
import ru.kpfu.itis.lzakharov.models.User;

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
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"ARTICLE\" ");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Article(result.getInt("article_id"), result.getString("title"),
                        result.getInt("author_id"), result.getTimestamp("timestamp"),
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
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"ARTICLE\" WHERE article_id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                article = new Article(result.getInt("article_id"), result.getString("title"),
                        result.getInt("author_id"), result.getTimestamp("timestamp"),
                        result.getString("description"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return article;
    }

    public static LinkedList<Article> getLastFiveArticles() {
        LinkedList<Article> articles = new LinkedList<>();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * " +
                    "FROM \"ARTICLE\" " +
                    "ORDER BY timestamp DESC " +
                    "LIMIT 5");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                articles.add(new Article(result.getInt("article_id"), result.getString("title"),
                        result.getInt("author_id"), result.getTimestamp("timestamp"),
                        result.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    public static int getCount() {
        int cnt = 0;

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT COUNT(*) FROM \"ARTICLE\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cnt = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt;
    }

    public static JSONObject getArticlesCut(int page) {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * " +
                    "FROM \"ARTICLE\" " +
                    "ORDER BY timestamp DESC " +
                    "LIMIT 5 " +
                    "OFFSET " + ((page - 1) * 5));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                JSONObject article = new JSONObject();
                article.put("article_id", resultSet.getInt("article_id"));
                article.put("title", resultSet.getString("title"));
                article.put("author_name", UserRepository.getNameById(resultSet.getInt("author_id")));
                article.put("timestamp", resultSet.getTimestamp("timestamp"));
                article.put("description", resultSet.getString("description"));
                array.put(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            object.put("results", array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }
}
