/**
 * @author Lev Zakharov
 * 11401
 * Created on 10.10.2014.
 */

import java.util.*;

public class Task032 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int LENGTH = 1000000;
        int n = in.nextInt();
        int[] a = new int[LENGTH];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            a[n - i - 1] = x;
        }

        int m = in.nextInt();
        int[] b = new int[LENGTH];
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            b[m - i - 1] = x;
        }

        int c = 0;
        int length = Math.max(n, m);

        for (int i = 0; i < length; i++) {
            c += a[i] + b[i];
            a[i] = c % 10;
            c /= 10;
        }

        if (c > 0) {
            a[length] = c;
            length++;
        }

        for (int i = length - 1; i > -1; i--) {
            System.out.print(a[i]);
        }

    }
}
