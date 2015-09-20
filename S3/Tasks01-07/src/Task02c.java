/**
 * @author Lev Zakharov
 * 11401
 * Created on 17.09.2015
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task02c {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Pattern p = Pattern.compile("(0+|1+|((01)+(0|)|(10)+(1|)))");

		for (int i = 1; i <= n; i++) {
			String s = in.nextLine();
			Matcher m = p.matcher(s);

			if (m.matches()) {
				System.out.println(i);
			}
		}
	}
}