/**
 * @author Lev Zakharov
 * 11401
 * Created on 05.11.2014.
 */

import java.util.*;

public class KPTask001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
        	a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
        	if (a[i] != -1) {
        		System.out.print(i + " ");
        		int k = a[i];
        		while (k != i) {
        			System.out.print(k + " ");
                    int foo = k;
                    k = a[k];
        			a[foo] = -1;
        		}
        		System.out.println();
        	}
        }

    }
}
