import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lzakharov on 22.11.15.
 */

public class Task24b {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ru.wikipedia.org/wiki/Лондон");

        StringBuilder html = new StringBuilder();

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while ((line = in.readLine()) != null) {
            html.append(line);
        }

        in.close();

        Pattern pattern = Pattern.compile("http://((\\w|\\.)*/)*(?<filename>((\\w|-|&)*\\.pdf))");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            try {
                URL pdfUrl = new URL(matcher.group());
                BufferedInputStream inputStream = new BufferedInputStream(pdfUrl.openStream());
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(matcher.group("filename"))));

                byte[] buf = new byte[1024];
                int n;

                while ((n = inputStream.read(buf)) >= 0) {
                    outputStream.write(buf, 0, n);
                }


                inputStream.close();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

