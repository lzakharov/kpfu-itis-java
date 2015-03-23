import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by lzakharov on 23.03.15.
 */
public class b19 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("in.txt"));
            String s;
            while ((s = input.readLine()) != null) {
                for (String number: s.split(" ")) {
                    a.add(Integer.parseInt(number));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            private int numberLength(Integer number) {
                int cnt = 0;
                while (number > 0) {
                    number /= 10;
                    cnt++;
                }

                return cnt;
            }
            @Override
            public int compare(Integer o1, Integer o2) {
                return numberLength(o1) - numberLength(o2);
            }
        };

        Collections.sort(a, comparator);

        try {
            PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
            Iterator<Integer> iterator = a.iterator();
            while (iterator.hasNext()) {
                out.println(iterator.next());
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
