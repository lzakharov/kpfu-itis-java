import java.util.*;

/**
 * Created by lzakharov on 02.04.15.
 */
public class GrammarTree {
    GrammarNode root;

    public GrammarTree(GrammarNode root) {
        this.root = root;
    }

    public GrammarNode getRoot() {
        return root;
    }

    private int[] zfunction(String s) {
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

    public void grammarTree(GrammarNode node, int n, HashMap<String, ArrayList<String>> grammar) {
        if (n != 0) {
            for (String string: grammar.keySet()) {
                String s = string + "#" + node.getValue();
                int[] z = zfunction(s);

                for (int i = string.length() + 1; i < s.length(); i++) {
                    if (z[i] == string.length()) {
                        String pref = "";
                        if (i - string.length() - 1 > 0) {
                            pref += node.getValue().substring(0, i - string.length() - 1);
                        }

                        for (String t: grammar.get(string)) {
                            String newNodeValue = pref + t;

                            if (i + string.length() < s.length()) {
                                newNodeValue += s.substring(i + string.length());
                            }

                            node.addSon(new GrammarNode(newNodeValue));
                        }
                    }
                }

            }

            for (GrammarNode son: node.getSons()) {
                grammarTree(son, n - 1, grammar);
            }
        }
    }

    public void DFS() {
        Stack<GrammarNode> stack = new Stack<GrammarNode>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            GrammarNode node = stack.pop();
            System.out.println(node.getValue());
            for (GrammarNode son: node.getSons()) {
                stack.push(son);
            }
        }
    }

    public void BFS() {
        Queue<GrammarNode> queue = new LinkedList<GrammarNode>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            GrammarNode node = queue.poll();
            System.out.println(node.getValue());
            for (GrammarNode son: node.getSons()) {
                queue.offer(son);
            }
        }
    }
}
