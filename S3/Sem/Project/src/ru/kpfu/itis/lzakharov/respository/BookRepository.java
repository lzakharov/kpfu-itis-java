package ru.kpfu.itis.lzakharov.respository;

import ru.kpfu.itis.lzakharov.models.Article;
import ru.kpfu.itis.lzakharov.models.Author;
import ru.kpfu.itis.lzakharov.models.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 30.10.15.
 */
public class BookRepository extends Repository {
    public static LinkedList<Book> getBooks() {
        LinkedList<Book> list = new LinkedList<>();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"BOOK\" ");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Book(result.getInt("book_id"),
                        result.getString("name"),
                        result.getInt("year"),
                        result.getString("publisher"),
                        result.getInt("rate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Book getBookById(int id) {
        Book book = null;

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"BOOK\" WHERE book_id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                book = new Book(result.getInt("book_id"), result.getString("name"),
                        result.getInt("year"), result.getString("publisher"), result.getInt("rate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    public static LinkedList<Author> getAuthors(int id) {
        LinkedList<Author> authors = new LinkedList<>();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT author_id, name, birthdate, rate " +
                    "FROM AUTHOR, BOOK_AUTHOR " +
                    "WHERE AUTHOR.author_id = BOOK_AUTHOR.author_id AND BOOK_AUTHOR.book_id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                authors.add(new Author(result.getInt("author_id"), result.getString("name"), result.getDate("birthdate"), result.getInt("rate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

    public static LinkedList<Book> getTopFiveBooks() {
        LinkedList<Book> books = new LinkedList<>();

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * FROM \"BOOK\" " +
                    "ORDER BY rate DESC " +
                    "LIMIT 5");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                books.add(new Book(result.getInt("book_id"), result.getString("name"),
                        result.getInt("year"), result.getString("publisher"), result.getInt("rate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
