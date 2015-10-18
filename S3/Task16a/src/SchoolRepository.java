import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 18.10.15.
 */
public class SchoolRepository extends Repository {
    public static School getSchoolById(int id) {
        School school = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM schools WHERE id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                school = new School(result.getInt("id"), result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return school;
    }
}
