import java.util.Scanner;

/**
 * Created by lzakharov on 07.05.15.
 */
public class b24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int k = in.nextInt();

        backTracking(m, k, "");
    }

    private static void backTracking(int m, int k, String number) {
        if (number.length() == m) {
            System.out.println(Integer.parseInt(number));
        } else {
            for (int i = 0; i < 10; i++) {
                if (digitsSum(number) + i < k) {
                    backTracking(m, k, number + i);
                }
            }
        }

    }

    private static int digitsSum(String number) {
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            sum += Character.digit(number.charAt(i), 10);
        }

        return sum;
    }

}
