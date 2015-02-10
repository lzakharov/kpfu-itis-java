/**
 * @author Lev Zakharov
 * 11401
 * Created on 30.09.2014.
 */

import java.util.*;

public class Task023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double EPS = 1e-9;
        double res = 0, x = 1, i = 1;

        while (x > EPS) {
            x = (2 * i + 3) / (5 * i * i * i * i + 1);
            res += x;
            i++;
        }

        System.out.println(res);
    }
}
