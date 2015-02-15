/**
 * Created by lzakharov on 11.02.15.
 */

import ru.kpfu.itis.group11401.lzakharov.Elem;

import java.util.Scanner;

public class c05 {
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

        p = head;
        int sum = 0;

        while (p != null) {
            if (p.getValue() % 2 == 0) {
                sum += p.getValue();
            }
            p = p.getNext();
        }

        System.out.println(sum);
    }
}