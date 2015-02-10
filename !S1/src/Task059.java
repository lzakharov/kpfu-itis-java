/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.RationalComplexMatrix2x2;
import ru.kpfu.itis.group11401.lzakharov.RationalComplexNumber;
import ru.kpfu.itis.group11401.lzakharov.RationalComplexVector2D;
import ru.kpfu.itis.group11401.lzakharov.RationalFraction;

import java.util.*;

public class Task059 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RationalComplexMatrix2x2 x = new RationalComplexMatrix2x2(new RationalComplexNumber(new RationalFraction(4, 2), new RationalFraction(2, 3)));
        RationalComplexMatrix2x2 y = new RationalComplexMatrix2x2(new RationalComplexNumber(new RationalFraction(3, 2), new RationalFraction(7, 3)));
        RationalComplexVector2D f = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(2, 2), new RationalFraction(1, 3)), new RationalComplexNumber(new RationalFraction(4, 3), new RationalFraction(4, 5)));

        System.out.println(x.det());
        System.out.println(x.add(y));
        System.out.println(x.mult(y));
        System.out.println(x.multVector(f));
    }
}
