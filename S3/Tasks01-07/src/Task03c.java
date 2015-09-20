/**
 * @author Lev Zakharov
 * 11401
 * Created on 17.09.2015
 */

import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task03c {
	public static void main(String[] args) {
		int cnt = 0;
		int res = 0;
		Pattern p = Pattern.compile("\\d+[02468]");

		while (res < 10) {
			Random random = new Random();
			int num = random.nextInt(1000000);
			Matcher m = p.matcher(Integer.toString(num));

			if (m.matches()) {
				System.out.println(num);
				res++;
			}

			cnt++;
		}	

		System.out.println("Total count: " + cnt);
	}
}