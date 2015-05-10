import java.util.Scanner;

/**
 * Created by lzakharov on 07.05.15.
 */
public class с24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        backTracking(n, "");
    }

    private static void backTracking(int n, String word) {
        if (word.length() == n) {
            System.out.println(word);
        } else {
            if (word.length() > 2 && isVowel(word.charAt(word.length() - 1)) && isVowel(word.charAt(word.length() - 2)) && isVowel(word.charAt(word.length() - 3))) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (!isVowel(ch)) {
                        backTracking(n, word + ch);
                    }
                }
            } else {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    backTracking(n, word + ch);
                }
            }
        }
    }

    private static boolean isVowel(char c) {
        if ("aeiou".indexOf(c) > -1) {
            return true;
        } else {
            return false;
        }
    }
}
