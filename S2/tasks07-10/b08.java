/**
 * Created by lzakharov on 22.02.15.
 */

import java.util.Scanner;
import ru.kpfu.itis.group11401.lzakharov.Elem;

public class b08 {
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
        Elem hundred;

        while (p != null) {
            if (p.getValue() % 2 == 0) {
                hundred = new Elem(100);
                hundred.setNext(p.getNext());
                p.setNext(hundred);
                p = p.getNext().getNext();
            } else {
                p = p.getNext();
            }
        }

        p = head;

        while (p != null) {
            System.out.println(p.getValue());
            p = p.getNext();
        }
    }
}
