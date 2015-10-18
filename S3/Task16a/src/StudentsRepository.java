import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 16.10.15.
 */
public class StudentsRepository extends Repository {
    public static Student getStudentById(int id) {
        Student student = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                student = new Student(result.getInt("id"), result.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}
