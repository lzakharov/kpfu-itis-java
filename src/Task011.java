/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = 1;

        for (int i = (n % 2 == 0) ? 2 : 3; i <= n; i += 2) {
            res *= i;
        }

        System.out.println(res);
    }
}
