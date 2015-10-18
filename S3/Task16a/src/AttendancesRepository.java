import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lzakharov on 16.10.15.
 */
public class AttendancesRepository extends Repository {
    public static LinkedList<Attendance> getStudentsClassesIdsBetweenYears(int firstYear, int secondYear) {
        LinkedList<Attendance> res = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * " +
                        "FROM attendance " +
                        "WHERE attendance.year BETWEEN 1992 AND 1998"
            );

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                res.add(new Attendance(result.getInt("class_id"),
                        result.getInt("teacher_id"),
                        result.getInt("year"),
                        result.getInt("student_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static LinkedList<Attendance> getStudentsByTeacherName(String teacherName) {
        LinkedList<Attendance> res = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM attendance, teachers " +
                    "WHERE teachers.name = '" + teacherName + "' AND attendance.teacher_id = teachers.id");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                res.add(new Attendance(result.getInt("class_id"),
                        result.getInt("teacher_id"),
                        result.getInt("year"),
                        result.getInt("student_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
}
