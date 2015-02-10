/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import ru.kpfu.itis.group11401.lzakharov.ComplexNumber;
import ru.kpfu.itis.group11401.lzakharov.ComplexVector2D;

import java.util.*;

public class Task054 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ComplexVector2D x = new ComplexVector2D(new ComplexNumber(1, 2), new ComplexNumber(2, 3));
        ComplexVector2D y = new ComplexVector2D(new ComplexNumber(1, 1), new ComplexNumber(5, 3));

        System.out.println(x.add(y));
        System.out.println(x.equals(y));
        System.out.println(x.scalarProduct(y));
    }
}
