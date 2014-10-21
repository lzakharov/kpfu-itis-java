/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.10.2014.
 */

import java.util.*;

public class Task039 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int[][] DIRECTIONS = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

        int p = in.nextInt();
        int[] a = new int[p];
        for (int i = 0; i < p; i++) {
        	a[i] = in.nextInt();
        }

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		b[i][j] = in.nextInt();
        	}
        }

        for (int number = 0; number < p; number++) {
            boolean flag = false;
        	for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
                    if (!flag) {
			       		for (int d = 0; ((d < 8)&&(!flag)); d++) {
                            int k = a[number];
		        		    int x = i;
			       			int y = j;
			       			int[][] ans = new int[6][2];
		        			int len = 0;

			               	while ((x > -1)&&(x < n)&&(y > -1)&&(y < m)&&(k > 0)&&(k % 10 == b[x][y])) {
			                    ans[len][0] = x;
			                    ans[len][1] = y;
			                    len++;
			                    k /= 10;
			                    x += DIRECTIONS[d][0];
			                    y += DIRECTIONS[d][1];
			                }

			                if (k == 0) {
			                    flag = true;
                                System.out.print(a[number] + ": ");
                                for (int t = len - 1; t > -1; t--) {
			                        System.out.print(ans[t][0] + ":" + ans[t][1] + " ");
			                    }
			                    System.out.println();
			                }
		                }
	        		}
        		}
        	}
            if (!flag) {
                System.out.println(a[number] + ": no");
            }
    	}
	}
}
