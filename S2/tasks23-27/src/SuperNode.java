import java.util.ArrayList;

/**
 * Created by lzakharov on 06.05.15.
 */
public class SuperNode {
    private int index;
    private int color;
    private ArrayList<SuperNode> neighbourhoods;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public SuperNode(int index) {
        this.index = index;
        this.color = -1;
        neighbourhoods = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<SuperNode> getNeighbourhoods() {
        return neighbourhoods;
    }

    public void addNeighbourhood(SuperNode neighbourhood) {
        neighbourhoods.add(neighbourhood);
    }

    @Override
    public boolean equals(Object o) {
        return (this.index == ((SuperNode)o).index);
    }
}
