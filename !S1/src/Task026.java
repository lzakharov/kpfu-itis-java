/**
 * @author Lev Zakharov
 * 11401
 * Created on 30.09.2014.
 */

import java.util.*;

public class Task026 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double EPS = 1e-9;
        double x = in.nextDouble();
        double res = 0, i = 1, a = 1, b = 1, k = 1;

        while (Math.abs(k) > EPS) {
            a *= (x - 1);
            b *= 3 * i;
            k = a / (b * (i * i + 3));
            res += k;
            i++;
        }

        System.out.println(res);
    }
}
