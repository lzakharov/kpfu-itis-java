/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.RationalFraction;
import ru.kpfu.itis.group11401.lzakharov.RationalVector2D;

import java.util.*;

public class Task053 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RationalVector2D x = new RationalVector2D(new RationalFraction(3, 4), new RationalFraction(1, 2));
        RationalVector2D y = new RationalVector2D(new RationalFraction(1, 4), new RationalFraction(1, 3));
        System.out.println(x.add(y));
        System.out.println(x.equals(y));
        System.out.println(x.scalarProduct(y));
        System.out.println(x.length());
    }
}
