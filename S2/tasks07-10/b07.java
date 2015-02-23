/**
 * Created by lzakharov on 22.02.15.
 */

import java.util.Scanner;
import ru.kpfu.itis.group11401.lzakharov.Elem;

public class b07 {
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

        while (p.getNext() != null) {
            if (p.getNext().getValue() % 2 == 1) {
                p.setNext(p.getNext().getNext());
            }

            p = p.getNext();
        }

        p = head;

        while (p != null) {
            System.out.println(p.getValue());
            p = p.getNext();
        }
    }
}
