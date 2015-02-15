/**
 * Created by lzakharov on 11.02.15.
 */
import ru.kpfu.itis.group11401.lzakharov.Elem;

import java.util.Scanner;

public class b05 {
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
        int mult = 1;

        while (p != null) {
            mult *= p.getValue();
            p = p.getNext();
            if (p != null) {
                p = p.getNext();
            }
        }

        System.out.println(mult);
    }
}
