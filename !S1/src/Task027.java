/**
 * @author Lev Zakharov
 * 11401
 * Created on 10.10.2014.
 */

import java.util.*;

public class Task027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean res = false;

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x % 6 == 0) {
                res = true;
            }
        }

        System.out.print(res);
    }
}
