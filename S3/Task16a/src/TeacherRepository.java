import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 18.10.15.
 */
public class TeacherRepository extends Repository {
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
