/**
 * @author Lev Zakharov
 *         11401
 *         Created on 10.09.2014.
 */
public class Task006 {
	public static void main(String[] args) {
		double x = 1.0;
		double result = 6.0 + x;
		result = 10.0 + result * x;
		result = 25.0 + result * x;
		result = 30.0 + result * x;
		result = 101.0 + result * x;

		System.out.println(result);
	}	
}
