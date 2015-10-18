/**
 * Created by lzakharov on 16.10.15.
 */
public class SchoolClass {
    private int id;
    private String name;

    public SchoolClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
