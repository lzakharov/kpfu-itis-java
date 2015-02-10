/**
 * @author Lev Zakharov
 * 11401
 */

import java.util.*;

public class Task047 {

	public static void multTable(int k) {
		for (int i = 2; i < 10; i++) {
			System.out.println(i + " * " + k + " = " + (i * k));
		}
	}

	public static double foo(double x) {
		final double EPS = 1e-9;
		double res = 0, i = 1, k = 1, a = 1;

        while (Math.abs(k) > EPS) {
            a *= 9 * (x - 1) * (x - 1);
            k = 1.0 / (i * a);
            res += k;
            i++;
        }

        return res;
	}

	public static double dotProduct(int n, int[] a, int[] b) {
		double ans = 0;

		for (int i = 0; i < n; i++) {
        	ans += a[i] * b[i];
        }

        return ans;
	}

	public static double cosBetweenVectors(int n, int[] a, int[] b) {
		double lengthA = 0, lengthB = 0;

        for (int i = 0; i < n; i++) {
        	lengthA += a[i] * a[i];
        }

		for (int i = 0; i < n; i++) {
        	lengthB += b[i] * b[i];
        }

        lengthA = Math.sqrt(lengthA);
        lengthB = Math.sqrt(lengthB);

        return dotProduct(n, a, b) / (lengthA * lengthB);
	}

    public static double[][] echelonForm(int n, double[][] a) {
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

        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int k = in.nextInt();
        multTable(k);

        double x = in.nextDouble();
        System.out.println(foo(x));

        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }


        System.out.println(dotProduct(n, a, b));
        System.out.println(cosBetweenVectors(n, a, b));

        n = in.nextInt();
        double[][] f = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = in.nextDouble();
            }
        }
        
        f = echelonForm(n, f);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }

    }
}