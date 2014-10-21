/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.10.2014.
 */

import java.util.*;

public class Task033 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        double lengthA = 0, lengthB = 0, ans = 0;

        for (int i = 0; i < n; i++) {
        	int x = in.nextInt();
        	a[i] = x;
        	lengthA += x * x;
        }

		for (int i = 0; i < n; i++) {
        	int x = in.nextInt();
        	b[i] = x;
        	lengthB += x * x;
        }

        lengthA = Math.sqrt(lengthA);
        lengthB = Math.sqrt(lengthB);

        for (int i = 0; i < n; i++) {
        	ans += a[i] * b[i];
        }

        ans /= lengthA * lengthB;

        System.out.println(ans);
    }
}
