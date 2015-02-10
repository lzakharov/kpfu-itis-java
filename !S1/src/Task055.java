/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.RationalFraction;
import ru.kpfu.itis.group11401.lzakharov.RationalMatrix2x2;
import ru.kpfu.itis.group11401.lzakharov.RationalVector2D;
import ru.kpfu.itis.group11401.lzakharov.Vector2D;

import java.util.*;

public class Task055 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RationalMatrix2x2 x = new RationalMatrix2x2(new RationalFraction(1, 2), new RationalFraction(3, 4), new RationalFraction(4, 5), new RationalFraction(6, 8));
        RationalMatrix2x2 y = new RationalMatrix2x2(new RationalFraction(5, 2), new RationalFraction(1, 4), new RationalFraction(4, 13), new RationalFraction(1, 8));
        RationalVector2D f = new RationalVector2D(new RationalFraction(1, 2), new RationalFraction(5, 9));
        System.out.println(x.det());
        System.out.println(x.add(y));
        System.out.println(x.mult(y));
        System.out.println(x.multVector(f));


    }
}
