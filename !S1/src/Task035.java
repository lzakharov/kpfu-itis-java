/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.10.2014.
 */

import java.util.*;

public class Task035 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
        	a[i] = in.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		if (a[i] > a[j]) {
        			int k = a[i];
        			a[i] = a[j];
        			a[j] = k;
        		}
        	}
        }

        for (int i = 0; i < n; i++) {
        	System.out.println(a[i]);
        }
    }
}
