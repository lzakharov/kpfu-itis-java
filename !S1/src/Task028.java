/**
 * @author Lev Zakharov
 * 11401
 * Created on 10.10.2014.
 */

import java.util.*;

public class Task028 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();

        for (int i = k + ((3 - (k % 3)) % 3); i < m + 1; i += 3) {
            System.out.println(i);
        }
    }
}
