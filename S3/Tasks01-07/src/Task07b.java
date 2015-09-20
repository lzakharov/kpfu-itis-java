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

public class Task07b {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("((http[s]?):\\/)?\\/?([^:\\/\\s]+)(?<path>((\\/\\w+)*\\/)([\\w\\-]+\\.\\w+))");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("index.html"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				Matcher m = p.matcher(line);
				while (m.find()) {
					System.out.println(m.group("path"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}