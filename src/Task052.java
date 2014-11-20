/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.11.2014.
 */

import java.util.*;
import ru.kpfu.itis.group11401.lzakharov.*;

public class Task052 {
    public static void main(String[] args) {
        Matrix2x2 x = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 y = new Matrix2x2(5, 3, 1, 2);
        Vector2D f = new Vector2D(1, 2);
        x.inverseMatrix();
        System.out.println(x.det());
        System.out.println(x.multNumber(5));
        System.out.println(x.equivalentDiagonal());
        System.out.println(x.mult(y));
        System.out.println(x.add(y));
        System.out.println(x.sub(y));
        System.out.println(x.multVector(f));
        x.add2(y);
        x.mult2(y);
        x.multNumber2(3);
        x.sub2(y);
    }
}
