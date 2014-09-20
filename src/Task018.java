/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class Task018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextInt();
        int n = in.nextInt();
        double res = 0, a;

        for (int i = 0; i < n; i++) {
            a = in.nextInt();
            res = (res + a) * x;
            System.out.println(res);
        }

        a = in.nextInt();
        System.out.println(res + a);
    }
}
