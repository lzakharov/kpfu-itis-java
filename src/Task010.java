/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2014.
 */

import java.util.*;

public class Task010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        double y;
        y = x > 2 ? (-1.0 + x * x) / (x + 2) : x > 0 ? (x * x - 1) * (x + 2) : (x * x) * (1 + 2 * x);

        System.out.println(y);
    }
}
