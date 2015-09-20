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

public class Task06c {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("(?<filename>[a-zA-Z0-9]+)\\.(?<extension>(jp(eg|g)|gif|png|css|js|xml|ico|php))");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("index.html"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				Matcher m = p.matcher(line);
				while (m.find()) {
					System.out.println("FILENAME: " + m.group("filename"));
					System.out.println("EXTENSION: " + m.group("extension"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}