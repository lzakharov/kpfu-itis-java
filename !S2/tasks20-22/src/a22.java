import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lzakharov on 02.04.15.
 */
public class a22 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> grammar = new HashMap<String, ArrayList<String>>();
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

        GrammarTree tree = new GrammarTree(new GrammarNode("S"));
        tree.grammarTree(tree.getRoot(), n, grammar);

        tree.BFS();
    }
}
