/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.11.2014.
 */

import java.util.*;
import ru.kpfu.itis.group11401.lzakharov.*;

public class Task050 {
    public static void main(String[] args) {
        RationalFraction x = new RationalFraction(6, 3);
        RationalFraction y = new RationalFraction(5, 3);
        x.reduce();
        System.out.println(x.mult(y));
        System.out.println(x.sub(y));
        System.out.println(x.add(y));
        System.out.println(x.div(y));
        System.out.println(x.equals(y));
        System.out.println(x.numberPart());
        x.add2(y);
        x.div2(y);
        x.sub2(y);
        x.mult2(y);
        System.out.println(x);
    }
}
