import java.util.Scanner;
import ru.kpfu.itis.group11401.lzakharov.MyLinkedStack;

/**
 * Created by lzakharov on 26.02.15.
 */
public class b14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        MyLinkedStack<Character> st = new MyLinkedStack<Character>();
        int i = 0;
        byte res = 0;
        char x;

        while (i < s.length() && res == 0) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    st.push(s.charAt(i));
                    break;
                case ')':
                    if (st.isEmpty()) {
                        res = 1;
                    } else {
                        x = st.pop();
                        if (x != '(') {
                            res = 2;
                        }
                    }
                    break;
                case ']':
                    if (st.isEmpty()) {
                        res = 1;
                    } else {
                        x = st.pop();
                        if (x != '[') {
                            res = 2;
                        }
                    }
                    break;
                case '}':
                    if (st.isEmpty()) {
                        res = 1;
                    } else {
                        x = st.pop();
                        if (x != '{') {
                            res = 2;
                        }
                    }
                    break;
            }

            i++;
        }

        if (res == 1) {
            System.out.println("встретилась лишняя закрывающая");
        } else
        if (res == 2) {
            System.out.println("скобки не соответствуют друг другу");
        } else
        if (!st.isEmpty()) {
            System.out.println("не все открывающие закрыты");
        } else {
            System.out.println("скобки расставлены правильно");
        }

    }
}
