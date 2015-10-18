import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 18.10.15.
 */
public class SchoolRepository extends Repository {
    public static LinkedList<School> getSchools(int id) {
        LinkedList<School> list = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM schools");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new School(result.getInt("id"), result.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

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
