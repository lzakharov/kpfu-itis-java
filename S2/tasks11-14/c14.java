import ru.kpfu.itis.group11401.lzakharov.MyLinkedStack;

import java.util.Scanner;

/**
 * Created by lzakharov on 08.03.15.
 */
public class c14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        MyLinkedStack<Integer> st = new MyLinkedStack<>();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            st.push(a[i]);
        }

        int i = 0;

        while (!st.isEmpty()) {
            a[i] = st.pop();
            i++;
        }

        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

    }
}
