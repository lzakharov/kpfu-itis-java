/**
 * Created by lzakharov on 12.02.15.
 */

import ru.kpfu.itis.group11401.lzakharov.Elem;

import java.util.Scanner;

public class a05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Elem head = null;
        Elem p;

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            p = new Elem(x, head);
            head = p;
        }

        Elem last = head;
        p = head.getNext();
        int min = 0, max = 0;

        while (p != null) {
            if (p.getValue() > last.getValue() && p.getValue() > p.getNext().getValue()) {
               max++;
            }
            if (p.getValue() < last.getValue() && p.getValue() < p.getNext().getValue()) {
                min++;
            }
            last = p;
            p = p.getNext();
        }

        System.out.println(min);
        System.out.println(max);
    }
}

