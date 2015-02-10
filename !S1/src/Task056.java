/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.ComplexMatrix2x2;
import ru.kpfu.itis.group11401.lzakharov.ComplexNumber;
import ru.kpfu.itis.group11401.lzakharov.ComplexVector2D;

import java.util.*;

public class Task056 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ComplexMatrix2x2 x = new ComplexMatrix2x2(new ComplexNumber(1, 2), new ComplexNumber(2, 3), new ComplexNumber(3, 4), new ComplexNumber(5, 4));
        ComplexMatrix2x2 y = new ComplexMatrix2x2(new ComplexNumber(5, 2), new ComplexNumber(2, 3), new ComplexNumber(3, 7), new ComplexNumber(1, 4));
        ComplexVector2D f = new ComplexVector2D(new ComplexNumber(3, 2), new ComplexNumber(5, 7));
        System.out.println(x.det());
        System.out.println(x.add(y));
        System.out.println(x.mult(y));
        System.out.println(x.multVector(f));
    }
}
