/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double s = 0, k = 1;

        for (int i = 1; i < 2 * n; i += 2) {
			s += k / i;
			k *= -1;
        }

        System.out.println(s);
    }
}
