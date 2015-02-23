/**
 * Created by lzakharov on 22.02.15.
 */

import java.util.Scanner;
import ru.kpfu.itis.group11401.lzakharov.Elem;

public class a09 {
    public static boolean isSimple(int x) {
        if (x == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int firstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }

        return x;
    }

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

        Elem x;

        if (isSimple(p.getValue())) {
            head = new Elem(firstDigit(p.getValue()), p);
            x = new Elem(p.getValue() % 10, p.getNext());
            p.setNext(x);
            p = p.getNext();
        }

        while (p.getNext() != null) {
            if (isSimple(p.getNext().getValue())) {
                x = new Elem(firstDigit(p.getNext().getValue()));
                x.setNext(p.getNext());
                p.setNext(x);
                x = new Elem(p.getNext().getNext().getValue() % 10);
                x.setNext(p.getNext().getNext().getNext());
                p.getNext().getNext().setNext(x);
                p = p.getNext().getNext().getNext();
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
