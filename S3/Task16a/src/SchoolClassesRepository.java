import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 16.10.15.
 */
public class SchoolClassesRepository extends Repository {
    public static SchoolClass getSchoolClassById(int id) {
        SchoolClass schoolClass = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM classes WHERE id = " + id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                schoolClass = new SchoolClass(result.getInt("id"), result.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schoolClass;
    }
}
