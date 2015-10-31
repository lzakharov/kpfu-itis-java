package ru.kpfu.itis.lzakharov.respository;

import ru.kpfu.itis.lzakharov.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 16.10.15.
 */
public class UserRepository extends Repository {
    public static String getNameById(int id) {
        String name = null;

        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT concat(first_name, ' ', last_name) as name FROM \"USER\" WHERE user_id = " + id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                name = result.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }

    public static User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * " +
                    "FROM \"USER\" " +
                    "WHERE user_id = " + id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                user = new User(resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static User getUserByUsername(String username) {
        User user = null;
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * " +
                    "FROM \"USER\" " +
                    "WHERE username = '" + username + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                user = new User(resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static User getUserByEmail(String email) {
        User user = null;
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("SELECT * " +
                    "FROM \"USER\" " +
                    "WHERE email = '" + email + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                user = new User(resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static void addUser(User user) {
        try {
            PreparedStatement statement = Repository.connection.prepareStatement("INSERT INTO \"USER\" VALUES (DEFAULT , ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmail());
            statement.setDate(6, user.getBirthdate());
            statement.setString(7, user.getAddress());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
