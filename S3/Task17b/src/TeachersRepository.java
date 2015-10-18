import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 18.10.15.
 */
public class TeachersRepository extends Repository {
    public static LinkedList<Teacher> getTeachers() {
        LinkedList<Teacher> list = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Teacher(result.getInt("id"),
                        result.getString("name"),
                        result.getInt("school_id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Teacher getTeacherById(int id) {
        Teacher teacher = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers WHERE id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                teacher = new Teacher(result.getInt("id"),
                        result.getString("name"),
                        result.getInt("school_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
