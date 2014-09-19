/**
 * @author Lev Zakharov
 * 11401
 * Created on 17.09.2014.
 */

import java.util.*;

public class Task021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");

            if (i == n - 1) {
                for (int j = 0; j < 2 * n - 2; j++) {
                    System.out.print("*");
                }
            } else if (i == 2 * n - 1) {
                for (int j = 0; j < 4 * n - 2; j++) {
                    if (j == 2 * n - 2) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
            } else if (i < n - 1) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }
                if (i != 0) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < 2 * (i - n) - 1; j++) {
                    System.out.print("*");
                }
                if (i != n) {
                    System.out.print("*");
                }
                for (int j = 0; j < 4 * n - 2 * i - 1 ; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                for (int j = 0; j < 2 * (i - n) - 1; j++) {
                    System.out.print("*");
                }
                if (i != n) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
