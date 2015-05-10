import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lzakharov on 09.05.15.
 */
public class b25 {
    public static void main(String[] args) {
        Graph graph = new Graph();

        try {
            BufferedReader fin = new BufferedReader(new FileReader("in.txt"));
            String s;
            while ((s = fin.readLine()) != null) {
                String[] t = s.split(" ");
                Edge edge = new Edge(new SuperNode(Integer.parseInt(t[0])), new SuperNode(Integer.parseInt(t[1])));
                graph.addEdge(edge);
                edge = new Edge(new SuperNode(Integer.parseInt(t[0])), new SuperNode(Integer.parseInt(t[1])));
                graph.addEdge(edge);
            }
        } catch (IOException e) {
        }

        for (SuperNode node: graph.getNodes()) {
            if (node.getColor() == -1) {
                painting(graph, node);
            }
        }
    }

    private static void painting(Graph graph, SuperNode node) {
        if (isPainted(graph)) {
            for (SuperNode x: graph.getAdjacencyLists()) {
                System.out.println(x.getIndex() + " " + x.getColor());
            }
        } else {
            boolean[] color = new boolean[4];
            for (SuperNode x: node.getNeighbourhoods()) {
                if (x.getColor() != -1) {
                    color[x.getColor()] = true;
                }
            }

            for (int i = 3; i > -1; i--) {
                if (!color[i]) {
                    node.setColor(i);
                    for (SuperNode x: node.getNeighbourhoods()) {
                        if (x.getColor() == -1) {
                            painting(graph, node);
                        }
                    }
                }
            }
        }
    }

    private static boolean isPainted(Graph graph) {
        boolean res = true;

        for (SuperNode node: graph.getNodes()) {
            if (node.getColor() == -1) {
                res = false;
            }
        }

        return res;
    }
}
