/**
 * Created by lzakharov on 22.02.15.
 */

import ru.kpfu.itis.group11401.lzakharov.Elem;
import java.util.Scanner;

public class c07 {
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

        p = head;

        while (p.getNext().getNext().getNext().getNext() != null) {
            p = p.getNext();
        }

        p.setNext(null);

        p = head;

        while (p != null) {
            System.out.println(p.getValue());
            p = p.getNext();
        }

    }
}
