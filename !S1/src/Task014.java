/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double x = in.nextDouble();
        double res = 0;

        for (int i = 0; i < n; i++) {
            res = Math.cos(res + x);
        }

        System.out.println(res);
    }
}
