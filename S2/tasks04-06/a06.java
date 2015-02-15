/**
 * Created by lzakharov on 12.02.15.
 */

import ru.kpfu.itis.group11401.lzakharov.Elem;

import java.util.Scanner;

public class a06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Elem head = null;
        Elem tail = null;
        Elem p;

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            p = new Elem(x);
            if (tail == null) {
                head = p;
                tail = p;
            } else {
                tail.setNext(p);
                tail = p;
            }
        }




    }
}
