import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 18.10.15.
 */
public class SchoolClassesRepository extends Repository {
    public static LinkedList<SchoolClass> getSchoolClasses() {
        LinkedList<SchoolClass> list = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM classes");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new SchoolClass(result.getInt("id"), result.getString("name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

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
