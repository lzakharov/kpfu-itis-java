import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 16.10.15.
 */
public class AttendancesRepository extends Repository {
    public static LinkedList<Attendance> getAttendances() {
        LinkedList<Attendance> list = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM attendance ");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Attendance(result.getInt("class_id"),
                        result.getInt("teacher_id"),
                        result.getInt("year"),
                        result.getInt("student_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
