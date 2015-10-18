import java.sql.*;

/**
 * Created by lzakharov on 18.10.15.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/virtual-schools",
                    "lzakharov",
                    "levad"
            );

            PreparedStatement statement1 = connection.prepareStatement("SELECT students.name AS student, classes.name AS class " +
                    "FROM attendance, students, classes " +
                    "WHERE attendance.student_id = students.id AND " +
                    "      attendance.class_id = classes.id AND " +
                    "      attendance.\"year\" BETWEEN 1992 AND 1998");

            ResultSet result1 = statement1.executeQuery();

            while (result1.next()) {
                System.out.println(result1.getString("student") + " " + result1.getString("class"));
            }

            PreparedStatement statement2 = connection.prepareStatement("SELECT students.name AS \"name\", attendance.year AS \"year\" " +
                    "FROM attendance, students, teachers " +
                    "WHERE teachers.name = 'Horace Slughorn' AND attendance.teacher_id = teachers.id AND attendance.student_id = students.id");

            ResultSet result2 = statement2.executeQuery();

            while (result2.next()) {
                System.out.println(result2.getString("name") + " " + result2.getString("year"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
