import java.util.ArrayList;

/**
 * Created by lzakharov on 19.04.15.
 */
public class GrammarNode {
    String value;
    ArrayList<GrammarNode> sons;

    public GrammarNode(String value) {
        this.value = value;
        this.sons = new ArrayList<GrammarNode>();
    }

    public GrammarNode(String value, ArrayList<GrammarNode> sons) {
        this.value = value;
        this.sons = sons;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addSon(GrammarNode newSon) {
        this.sons.add(newSon);
    }

    public ArrayList<GrammarNode> getSons() {
        return this.sons;
    }
}
