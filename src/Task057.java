/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.RationalComplexNumber;
import ru.kpfu.itis.group11401.lzakharov.RationalFraction;

import java.util.*;

public class Task057 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RationalComplexNumber x = new RationalComplexNumber(new RationalFraction(1, 2), new RationalFraction(4, 7));
        RationalComplexNumber y = new RationalComplexNumber(new RationalFraction(2, 8), new RationalFraction(2, 6));
        System.out.println(x);
        System.out.println(x.add(y));
        System.out.println(x.sub(y));
        System.out.println(x.mult(y));
    }
}
