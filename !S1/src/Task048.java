/**
 * @author Lev Zakharov
 * 11401
 * Created on 12.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.Student;
import ru.kpfu.itis.group11401.lzakharov.Teacher;

public class Task048 {
    public static void main(String[] args) {
        Student student = new Student("Захаров Л. Ю.", 1996);
        Teacher teacher = new Teacher("Арсланов М. М.", "линейная алгебра");

        teacher.rate(student);
    }
}
