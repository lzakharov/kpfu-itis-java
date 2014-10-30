/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.10.2014.
 */

import java.util.*;

public class Task038 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[][] a = new double[n][n];

        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		a[i][j] = in.nextDouble();
        	}
        }

        for (int i = 0; i < n - 1; i++) {
            boolean zero = true;

            for (int j = i; ((j < n)&&(zero)); j++) {
                if (a[j][i] != 0) {
                    zero = false;

                    if (j != i) {
                        for (int t = 0; t < n; t++) {
                            double k = a[i][t];
                            a[i][t] = a[j][t];
                            a[j][t] = k;
                        }
                    }
                }
            }

            if (!zero) {
                for (int j = i + 1; j < n; j++) {
                    double k = a[j][i] / a[i][i];
                    for (int t = 0; t < n; t++) {
                        a[j][t] -= k * a[i][t];
                    }
                }
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
