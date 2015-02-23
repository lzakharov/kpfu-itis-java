/**
 * Created by lzakharov on 23.02.15.
 */

import ru.kpfu.itis.group11401.lzakharov.Elem;
import java.util.Scanner;

public class a10 {
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

        int number = 0;
        int k = 1;

        p = head;

        while (p != null) {
            if (p.getValue() == 1) {
                number += k;
            }

            k *= 2;
            p = p.getNext();
        }

        Elem resHead = null;

        while (number > 0) {
            p = new Elem(number % 10, resHead);
            resHead = p;
            number /= 10;
        }

        p = resHead;

        while (p != null) {
            System.out.print(p.getValue());
            p = p.getNext();
        }


    }
}
