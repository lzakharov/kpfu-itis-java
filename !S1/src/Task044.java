/**
 * @author Lev Zakharov
 * 11401
 * Created on 29.10.2014.
 */

import java.util.*;

public class Task044 {
	public static boolean check(String s) {
        if (!s.substring(0, 1).equals(s.substring(0, 1).toUpperCase())) {
            return false;
		}

		for (int i = 1; i < s.length(); i++) {
            if (!s.substring(i, i + 1).equals(s.substring(i, i + 1).toLowerCase())) {
				return false;
			}
		}

		return true;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
        	String s = in.next();
        	if (check(s)) {
        		System.out.print(s + ' ');
        	}
        }
    }
}
