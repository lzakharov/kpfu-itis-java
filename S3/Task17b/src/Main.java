import java.util.LinkedList;

/**
 * Created by lzakharov on 18.10.15.
 */
public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        LinkedList<Attendance> attendances = AttendancesRepository.getAttendances();
        printStudentsClassesBetweenYears(attendances, 1992, 1998);
        printStudentsYears(attendances, "Horace Slughorn");
    }

    private static void printStudentsYears(LinkedList<Attendance> attendances, String teacher) {
        for (Attendance attendance: attendances) {
            if (attendance.getTeacher().getName().equals(teacher)) {
                System.out.println(attendance.getStudent().getName() + " " + attendance.getYear());
            }
        }
    }

    private static void printStudentsClassesBetweenYears(LinkedList<Attendance> attendances, int year1, int year2) {
        for (Attendance attendance: attendances) {
            if (attendance.getYear() >= year1 && attendance.getYear() <= year2) {
                System.out.println(attendance.getStudent().getName() + " " + attendance.getSchoolClass().getName());
            }
        }
    }
}
