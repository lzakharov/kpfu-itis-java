/**
 * @author Lev Zakharov
 * 11401
 * Created on 17.09.2014.
 */

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 1;

        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        System.out.print(res);

    }
}
