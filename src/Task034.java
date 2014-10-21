/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.10.2014.
 */

import java.util.*;

public class Task034 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int max = x + y + z;

        for (int i = 3; i < n; i++) {
        	x = y;
        	y = z;
        	z = in.nextInt();
        	if (x + y + z > max) {
        		max = x + y + z;
        	}
        }

        System.out.println(max);
    }
}
