/**
 * @author Lev Zakharov
 * 11401
 * Created on 05.11.2014.
 */

import java.util.*;

public class KPTask002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] a = new int[n][n];
		
		int i = n - 1;
		int j = n - 1;
		int k = 0;

		while (k < n * n) {
			if (j == n - 1) {
				while (j > -1) {
					a[i][j] = k;
					k++;
					j--;	
				}

                j++;
			} else {
				while (j < n) {
					a[i][j] = k;
					k++;
					j++;
				}

                j--;
			}

			i--;
		}

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(a[x][y] + " ");
            }
            System.out.println();
        }
    }


}
