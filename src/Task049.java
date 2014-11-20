/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.11.2014.
 */

import java.util.*;
import ru.kpfu.itis.group11401.lzakharov.*;

public class Task049 {
    public static void main(String[] args) {
        Vector2D x = new Vector2D(4, 3);
        Vector2D y = new Vector2D(2, 5);
        System.out.println(x.length());
        System.out.println(x.mult(3));
        System.out.println(x.add(y));
        System.out.println(x.equals(y));
        System.out.println(x.scalarProduct(y));
        System.out.println(x.sub(y));
        x.add2(y);
        x.mult2(2);
        x.sub2(y);

        System.out.println(x);
    }
}
