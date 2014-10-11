/**
 * @author Lev Zakharov
 * 11401
 * Created on 10.10.2014.
 */

import java.util.*;

public class Task029 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int res = 0, x = 1;

        while (n > 0) {
            res += (n % 10) * x;
            x *= k;
            n /= 10;
        }

        System.out.println(res);
    }
}
