/**
 * @author Lev Zakharov
 * 11401
 * Created on 30.09.2014.
 */

import java.util.*;

public class Task025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double EPS = 1e-4;
        double res = 0, x = 1, i = 1, a = -1;

        while (Math.abs(x) > EPS) {
            a *= -1;
            x = a / (3.0 * i + i * i);
            res += x;
            i++;
        }

        System.out.println(res);
    }
}
