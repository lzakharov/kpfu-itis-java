/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class Task020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < 2 * n + 1; i++) {
            for (int j = 0; j < Math.abs(n - i); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * n + 1 - Math.abs(2 * (n - i)); j++) {
                System.out.print("0");
            }
            for (int j = 0; j < Math.abs(n - i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
