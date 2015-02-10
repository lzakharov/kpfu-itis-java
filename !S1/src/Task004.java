/**
 * @author Lev Zakharov
 *         11401
 *         Created on 10.09.2014.
 */
public class Task004 {
	public static void main(String[] args) {
		double x = 10.0;
		double y = 10.0;
		double a = 1.0 + y;
		double b = x * x;
		b -= 4;
		b = 1.0 / b;
		b += y;
		double c = x + y;
		c /= b;
		double d = 2 * x;
		double e = y * y;
		d += e;
		d -= c;
		System.out.println(a * d);
	}
}
