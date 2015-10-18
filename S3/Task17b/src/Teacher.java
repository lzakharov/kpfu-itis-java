/**
 * Created by lzakharov on 16.10.15.
 */
public class Teacher {
    private int id;
    private String name;
    private int school_id;
    private School school;

    public Teacher(int id, String name, int school_id) {
        this.id = id;
        this.name = name;
        this.school_id = school_id;
        this.school = SchoolRepository.getSchoolById(school_id);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
