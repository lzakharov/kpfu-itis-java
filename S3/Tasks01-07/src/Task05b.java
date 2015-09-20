/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2015
 */

import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task05b {
	public static void main(String[] args) {
		int cnt = 0;
		int res = 0;
		Pattern p = Pattern.compile("\\d*[02468]{2}\\d*[02468]{2}\\d*");

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
		System.out.println("===================");

		cnt = 0;
		res = 0;
		p = Pattern.compile("[02468]{2}");

		while (res < 10) {
			Random random = new Random();
			int num = random.nextInt(1000000);
			Matcher m = p.matcher(Integer.toString(num));

			if (m.find() && m.find()) {
				System.out.println(num);
				res++;
			}

			cnt++;
		}

		System.out.println("Total count: " + cnt);
	}
}