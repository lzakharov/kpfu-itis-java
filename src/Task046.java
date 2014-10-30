/**
 * @author Lev Zakharov
 * 11401
 * Created on 29.10.2014.
 */

import java.util.*;

public class Task046 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        if (a.compareTo(b) < 0) {
            System.out.println(a + " < " + b);
        } else
        if (a.compareTo(b) == 0) {
            System.out.println(a + " = " + b);
        } else {
            System.out.println(a + " > " + b);
        }
    }
}
