import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 16.10.15.
 */
public class StudentsRepository extends Repository {
    public static LinkedList<Student> getStudents() {
        LinkedList<Student> list = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Student(result.getInt("id"), result.getString("name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

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
