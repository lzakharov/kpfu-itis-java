/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import java.util.*;

public class YinAndYang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < 2 * n + 1; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                if ((i - n) * (i - n) + (j - n) * (j - n) <= n * n) {
                    if ((i - (n / 3)) * (i - (n / 3)) + (j - (n)) * (j - (n)) <= (n * n / 64)) {
                        System.out.print("#");
                    } else if ((i - (n + 2 * n / 3)) * (i - (n + 2 * n / 3)) + (j - (n)) * (j - (n)) <= (n * n / 64)) {
                        System.out.print(".");
                    } else if ((i - (n / 2)) * (i - (n / 2)) + (j - (n)) * (j - (n)) <= (n * n / 4)) {
                        System.out.print(".");
                    } else if ((i - (n + n / 2)) * (i - (n + n / 2)) + (j - (n)) * (j - (n)) <= (n * n / 4)) {
                        System.out.print("#");
                    } else if (j < n + 1) {
                        System.out.print(".");
                    } else if (j > n + 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(".");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
