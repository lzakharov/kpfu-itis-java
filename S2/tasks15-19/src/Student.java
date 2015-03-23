import java.util.ArrayList;

/**
 * Created by lzakharov on 17.03.15.
 */
public class Student {
    private String name;
    private ArrayList<String> results;

    public Student(String name, ArrayList<String> results) {
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        String res = this.name + " ";
        for (String s: this.results) {
            res += s;
        }

        return res;
    }

    public void addData(ArrayList<String> results) {
        for (String result: results) {
            this.results.add(result);
        }
    }

    public void addTask(String task) {
        this.results.add(task);
    }
}
