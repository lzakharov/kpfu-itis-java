/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.11.2014.
 */

import java.util.*;
import ru.kpfu.itis.group11401.lzakharov.*;

public class Task051 {
    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(1, 2);
        ComplexNumber y = new ComplexNumber(2, 3);
        System.out.println(x.arg());
        System.out.println(x.cos());
        System.out.println(x.complexNumberPow(3));
        System.out.println(x.length());
        System.out.println(x.sin());
        x.add2(y);
        x.mult2(y);
        x.sub2(y);
        x.complexNumberPow2(2);
        x.div2(y);
        System.out.println(x);

    }
}
