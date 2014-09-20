/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        double y;

        if (x > 2) {
            y = (-1.0 + x * x) / (x + 2);
        } else if (x > 0) {
            y = (x * x - 1) * (x + 2);
        } else {
            y = (x * x) * (1 + 2 * x);
        }

        System.out.println(y);
    }
}
