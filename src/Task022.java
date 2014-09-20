/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.09.2014.
 */

import com.sun.security.auth.SolarisNumericUserPrincipal;
import sun.java2d.SurfaceDataProxy;

import java.util.*;

public class Task022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < 2 * n + 1; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                if ((i - n) * (i - n) + (j - n) * (j - n) <= n * n) {
                    System.out.print("0");
                } else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }
}
