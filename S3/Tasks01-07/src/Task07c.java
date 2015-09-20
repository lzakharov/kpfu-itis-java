/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.09.2015
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task07c {
	public static void main(String[] args) {
		Pattern urlPattern = Pattern.compile("((http[s]?):\\/)?\\/?([^:\\/\\s]+)(((\\/\\w+)*\\/)([\\w\\-]+\\.\\w+))(?<params>((\\?|\\&)([a-zA-Z0-9+\\-_.!~*'()]+=)([a-zA-Z0-9+\\-_.!~*'()]+))+)");
		Pattern paramsPattern = Pattern.compile("(\\?|\\&)(?<name>([a-zA-Z0-9+\\-_.!~*'()])+)\\=(?<value>[a-zA-Z0-9+\\-_.!~*'()]+)");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("index.html"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				Matcher urlMatcher = urlPattern.matcher(line);
				while (urlMatcher.find()) {
					String urlParams = urlMatcher.group("params");
					System.out.println("PARAM STRING: " + urlParams);

					Matcher paramsMatcher = paramsPattern.matcher(urlParams);
					while (paramsMatcher.find()) {
						System.out.println("NAME: " + paramsMatcher.group("name"));	
						System.out.println("VALUE: " + paramsMatcher.group("value"));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}