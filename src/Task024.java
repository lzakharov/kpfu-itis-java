/**
 * @author Lev Zakharov
 * 11401
 * Created on 30.09.2014.
 */

import java.util.*;

public class Task024 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double EPS = 1e-9;
        double x = in.nextDouble();
        double res = 0, i = 1, k = 1, a = 1;

        while (Math.abs(k) > EPS) {
            a *= 9 * (x - 1) * (x - 1);
            k = 1.0 / (i * a);
            res += k;
            i++;
        }

        System.out.println(res);
    }
}
