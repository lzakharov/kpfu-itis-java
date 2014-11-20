/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.RationalComplexNumber;
import ru.kpfu.itis.group11401.lzakharov.RationalComplexVector2D;
import ru.kpfu.itis.group11401.lzakharov.RationalFraction;

import java.util.*;

public class Task058 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RationalComplexVector2D x = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(1, 2), new RationalFraction(3, 4)), new RationalComplexNumber(new RationalFraction(2, 3), new RationalFraction(5, 7)));
        RationalComplexVector2D y = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(1, 4), new RationalFraction(3, 5)), new RationalComplexNumber(new RationalFraction(7, 2), new RationalFraction(1, 7)));

        System.out.println(x.add(y));
        System.out.println(x.scalarProduct(y));
    }
}
