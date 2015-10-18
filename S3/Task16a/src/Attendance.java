/**
 * Created by lzakharov on 16.10.15.
 */
public class Attendance {
    private int class_id;
    private SchoolClass schoolClass;
    private int teacher_id;
    private Teacher teacher;
    private int year;
    private int student_id;
    private Student student;

    public Attendance(int class_id, int teacher_id, int year, int student_id) {
        this.class_id = class_id;
        this.schoolClass = SchoolClassesRepository.getSchoolClassById(class_id);
        this.teacher_id = teacher_id;
        this.teacher = TeacherRepository.getTeacherById(teacher_id);
        this.year = year;
        this.student_id = student_id;
        this.student = StudentsRepository.getStudentById(student_id);
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getYear() {
        return year;
    }

    public Student getStudent() {
        return student;
    }
}
