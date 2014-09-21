/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class Task015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double x = in.nextDouble();
        double s = x;

        for (int i = n; i > 1; i--) {
            s = x / (i + s);
        }

        System.out.println(s + 1);
    }
}
