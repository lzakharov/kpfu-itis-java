import ru.kpfu.itis.group11401.lzakharov.MyLinkedStack;

import java.util.Scanner;

/**
 * Created by lzakharov on 26.02.15.
 */
public class a14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split(",");

        MyLinkedStack<String> st = new MyLinkedStack<String>();
        int i = 0;
        int x, y;

        while (i < a.length) {
            switch (a[i]) {
                case "+":
                    x = Integer.parseInt(st.pop());
                    y = Integer.parseInt(st.pop());
                    st.push(Integer.toString(x + y));
                    break;
                case "-":
                    x = Integer.parseInt(st.pop());
                    y = Integer.parseInt(st.pop());
                    st.push(Integer.toString(x - y));
                    break;
                case "*":
                    x = Integer.parseInt(st.pop());
                    y = Integer.parseInt(st.pop());
                    st.push(Integer.toString(x * y));
                    break;
                case "/":
                    x = Integer.parseInt(st.pop());
                    y = Integer.parseInt(st.pop());
                    st.push(Integer.toString(x / y));
                    break;
                default:
                    st.push(a[i]);
            }

            i++;
        }

        System.out.println(st.pop());
    }
}
