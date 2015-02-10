/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class Task019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 2; i < 1000001; i++) {
            int sum = 1;
            int j = 2;

            while (j <= Math.sqrt(i)) {
                if ((i % j == 0) && (j * j != i)) {
                    sum += j + (i / j);
                } else if (i % j == 0) {
                    sum += j;
                }

                j++;
            }

            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
