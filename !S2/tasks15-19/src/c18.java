import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lzakharov on 23.03.15.
 */
public class c18 {
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

        Collections.sort(vectors);

        for (Vector2D v: vectors) {
            System.out.println(v);
        }

    }
}
