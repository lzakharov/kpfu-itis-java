/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class Task016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int s = 0, k = 1;

        for (int i = 1; i < n + 1; i++) {
            k *= x + i;
            s += k;
        }

        System.out.println(s);
    }
}
