import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by lzakharov on 23.03.15.
 */
public class с19 {
    public static void main(String[] args) {
        ArrayList<Vector2D> vectors = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("vectors.txt"));
            String s;
            while ((s = input.readLine()) != null) {
                String[] t = s.split(" ");
                vectors.add(new Vector2D(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<Vector2D> comparator = new Comparator<Vector2D>() {
            @Override
            public int compare(Vector2D o1, Vector2D o2) {
                if (o1.getX() < o2.getX()) {
                    return -1;
                } else if (o1.getX() == o2.getX()) {
                    if (o1.getY() < o2.getY()) {
                        return -1;
                    } else if (o1.getY() == o2.getY()) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(vectors, comparator);

        for (Vector2D v : vectors) {
            System.out.println(v);
        }
    }
}
