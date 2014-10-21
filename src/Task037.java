/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.10.2014.
 */

import java.util.*;

public class Task037 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < (n / 2); i++) {
            for (int j = 0; j < i + 1; j++) {
                a[i][j] = in.nextInt();
            }

            for (int j = i + 1; j < (n - i - 1); j++) {
                int x = in.nextInt();
                a[i][j] = 0;
            }

            for (int j = (n - i - 1); j < n; j++) {
                a[i][j] = in.nextInt();
            }

        }

        if (n % 2 == 1) {
            for (int j = 0; j < n; j++) {
                a[n / 2][j] = in.nextInt();
            }
        }

        for (int i = (n + 1) / 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                a[i][j] = in.nextInt();
            }

            for (int j = n - i; j < i; j++) {
                int x = in.nextInt();
                a[i][j] = 0;
            }

            for (int j = i; j < n; j++) {
                a[i][j] = in.nextInt();
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
