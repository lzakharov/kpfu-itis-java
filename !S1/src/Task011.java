/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = 1;

		while (n > 0) {
			res *= n;
			n -= 2;
		}

        System.out.println(res);
    }
}
