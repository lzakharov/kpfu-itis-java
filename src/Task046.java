/**
 * @author Lev Zakharov
 * 11401
 * Created on 29.10.2014.
 */

import java.util.*;

public class Task046 {
    public static int cmp(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return 1;
            } else if (a.charAt(i) < b.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        if (cmp(a, b) < 0) {
            System.out.println(a + " < " + b);
        } else if (cmp(a, b) == 0) {
            System.out.println(a + " == " + b);
        } else {
            System.out.println(a + " > " + b);
        }
    }
}
