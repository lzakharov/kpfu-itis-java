/**
 * @author Lev Zakharov
 * 11401
 * Created on 29.10.2014.
 */

import java.util.*;

public class Task045 {
	public static int isIn(String s, String[] names, int top) {
		for (int i = 0; i < top; i++) {
			if (s.equals(names[i])) {
				return i;
			}
		}

		return -1;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] names = new String[1000];
        int[] results = new int[1000];
        int top = 0;

        for (int i = 0; i < n; i++) {
        	String nameA = in.next();
        	String nameB = in.next();
        	String score = in.next();
        	String[] result = score.split(":");
            System.out.println(result[0] + " " + result[1]);

        	int pos = isIn(nameA, names, top);
        	if (pos != -1) {
				results[pos] += Integer.parseInt(result[0]);
				results[pos] -= Integer.parseInt(result[1]);
			} else {
				names[top] = nameA;
				results[top] = Integer.parseInt(result[0]) - Integer.parseInt(result[1]);
				top++;
			}

			pos = isIn(nameB, names, top);
        	if (pos != -1) {
				results[pos] -= Integer.parseInt(result[0]);
				results[pos] += Integer.parseInt(result[1]);
			} else {
				names[top] = nameB;
				results[top] = Integer.parseInt(result[1]) - Integer.parseInt(result[0]);
				top++;
			}
		}

		for (int i = 0; i < top; i++) {
			System.out.println(names[i] + " " + results[i]);
		}
    }
}
