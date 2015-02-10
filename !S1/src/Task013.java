/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        double res = 1;

        for (long i = 1; i < n + 1; i++) {
            res *= (double)(4 * i * i) / ((2 * i - 1) * (2 * i + 1));
        }

        System.out.println(res);
    }
}
