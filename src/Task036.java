/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.10.2014.
 */

import java.util.*;

public class Task036 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = in.nextInt();
        System.out.println(max);

        for (int i = 1; i < n; i++) {
        	int x = in.nextInt();
        	if (x > max) {
        		System.out.println(x);
        		max = x;
        	}
        }
    }
}
