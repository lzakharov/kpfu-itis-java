/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class Task017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double s = 0.5, k = 0.5;

        for (int i = 2; i < n + 1; i++) {
            k *= (double)((i - 1) * (i - 1)) / ((2 * i - 1) * (2 * i));
            s += k;
        }

        System.out.println(s);

    }
}
