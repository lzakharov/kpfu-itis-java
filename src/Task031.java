/**
 * @author Lev Zakharov
 * 11401
 * Created on 10.10.2014.
 */

import java.util.*;

public class Task031 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        boolean flag = true;

        for (int i = 0; flag && i < n; i++) {
            int x = in.nextInt();
            a[i] = x;
            if (((i + 1) % 3 == 0)&&(a[i] % 3 != 0)) {
                flag = false;
            }
        }

        if (flag) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > 0) {
                    res += a[i];
                }
            }

            System.out.println(res);
        } else {
            int res = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] > 0) {
                    res *= a[i];
                }
            }

            System.out.println(res);
        }
    }
}
