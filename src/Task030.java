/**
 * @author Lev Zakharov
 * 11401
 * Created on 10.10.2014.
 */

import java.util.*;

public class Task030 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;

        for (int i = 0; cnt < 3 && i < n; i++) {
            int x = in.nextInt();
            int k = x, length = 0, num = x % 10;
            boolean numParity = true;

            while (k > 0) {
                length++;
                if ((k % 10) % 2 != num % 2) {
                    numParity = false;
                }

                num = k % 10;

                k /= 10;
            }

            if (((length == 3)||(length == 5))&&(numParity)) {
                cnt++;
            }
        }

        if (cnt == 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
