import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzakharov on 03.03.15.
 */

public class c17 {
    public static void main(String[] args) {
        HashMap<Character, Integer> a = new HashMap<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            String s;
            while ((s = input.readLine()) != null) {
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isAlphabetic(s.charAt(i))) {
                        if (a.containsKey(s.charAt(i))) {
                            a.put(s.charAt(i), a.get(s.charAt(i)) + 1);
                        } else {
                            a.put(s.charAt(i), 1);
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Character, Integer> x: a.entrySet()) {
            System.out.println(x.getKey() + " -> " + x.getValue());
        }

    }
}

