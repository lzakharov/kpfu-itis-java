/**
 * Created by lzakharov on 11.02.15.
 */

import ru.kpfu.itis.group11401.lzakharov.Elem;

import java.util.Scanner;

public class c04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Elem head = null;

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            Elem p = new Elem(x, head);
            head = p;
        }

        Elem p = head;
        boolean flag = false;

        while (p != null && !flag) {
            if (p.getValue() == 0) {
                flag = true;
            }
            p = p.getNext();
        }

        System.out.println(flag);
    }
}