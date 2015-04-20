import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lzakharov on 20.04.15.
 */
public class b22 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> grammar = new HashMap<>();
        int n = 0;

        try {
            BufferedReader fin = new BufferedReader(new FileReader("input.txt"));
            String s = fin.readLine();
            n = Integer.parseInt(s);

            while ((s = fin.readLine()) != null) {
                String t[] = s.split(" -> ");
                String f[] = t[1].split("\\|");
                ArrayList<String> strs = new ArrayList<String>();
                for (String string: f) {
                    strs.add(string);
                }
                grammar.put(t[0], strs);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("S");
        ArrayList<String> res = new ArrayList<>();

        while (n > 0) {
            String w = queue.remove();
            if (isWord(w)) {
                res.add(w);
                n--;
            }

            for (String string: grammar.keySet()) {
                String s = string + "#" + w;
                int[] z = zfunction(s);

                for (int i = string.length() + 1; i < s.length(); i++) {
                    if (z[i] == string.length()) {
                        String pref = "";
                        if (i - string.length() - 1 > 0) {
                            pref += w.substring(0, i - string.length() - 1);
                        }

                        for (String t : grammar.get(string)) {
                            String newString = pref + t;

                            if (i + string.length() < s.length()) {
                                newString += s.substring(i + string.length());
                            }

                            queue.offer(newString);
                        }
                    }
                }
            }
        }

        for (String string: res) {
            System.out.println(string);
        }
    }

    private static int[] zfunction(String s) {
        int[] z = new int[s.length()];
        z[0] = s.length();
        int l = 0, r = 0;
        int j;

        for (int i = 1; i < s.length(); i++) {
            if (i > r){
                for (j = 0; ((j + i) < s.length()) && (s.charAt(i + j) == s.charAt(j)) ; j++);
                z[i] = j;
                l = i;
                r = i + j - 1;
            } else if (z[i - l] < r - i + 1)
                z[i] = z[i - l];
            else{
                for (j = 1; ((j + r) < s.length()) && (s.charAt(r + j) == s.charAt(r - i + j)); j++);
                z[i] = r - i + j;
                l = i;
                r = r + j - 1;
            }
        }

        return z;
    }

    private static boolean isWord(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
