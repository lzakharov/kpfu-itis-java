import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lzakharov on 06.05.15.
 */
public class Graph implements Serializable {
    private ArrayList<SuperNode> nodes;
    private int size;

    public Graph() {
        nodes = new ArrayList<>();
        size = 0;
    }

    public ArrayList<SuperNode> getNodes() {
        return nodes;
    }

    public int getSize() {
        return size;
    }

    public void addNode(SuperNode node) {
        node.setIndex(size);
        size++;
        nodes.add(node);
    }

    public void addEdge(Edge edge) {
        if (nodes.contains(edge.getHead())) {
            nodes.get(edge.getHead().getIndex() - 1).addNeighbourhood(edge.getTail());
        } else {
            SuperNode node = new SuperNode(edge.getHead().getIndex());
            node.addNeighbourhood(new SuperNode(edge.getTail().getIndex()));
            nodes.add(node);
        }

        size = 1 + Math.max(size, Math.max(edge.getHead().getIndex(), edge.getTail().getIndex()));
    }

    public ArrayList<Edge> getEdgesList() {
        return convertAdjacencyListToEdgesList(this.getAdjacencyLists());
    }

    public int[][] getAdjacencyMatrix() {
        return convertAdjacencyListToAdjacencyMatrix(this.getAdjacencyLists(), size);
    }

    public int[][] getIncidenceMatrix() {
        return convertAdjacencyListToIncidenceMatrix(this.getAdjacencyLists(), size);
    }

    public ArrayList<SuperNode> getAdjacencyLists() {
        return nodes;
    }

    // AdjacencyList converting
    public static ArrayList<Edge> convertAdjacencyListToEdgesList(ArrayList<SuperNode> adjacencyList) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (SuperNode node: adjacencyList) {
            for (SuperNode neighbourhood: node.getNeighbourhoods()) {
                edges.add(new Edge(node, neighbourhood));
            }
        }

        return edges;
    }

    public static int[][] convertAdjacencyListToAdjacencyMatrix(ArrayList<SuperNode> adjacencyList, int size) {
        int[][] adjacencyMatrix = new int[size][size];

        for (SuperNode node: adjacencyList) {
            for (SuperNode neighbourhood: node.getNeighbourhoods()) {
                adjacencyMatrix[node.getIndex()][neighbourhood.getIndex()] = 1;
            }
        }

        return adjacencyMatrix;
    }

    private static int countEdgesInAdjacencyList(ArrayList<SuperNode> adjacencyList) {
        int num = 0;

        for (SuperNode node: adjacencyList) {
            num += node.getNeighbourhoods().size();
        }

        return num;
    }

    public static int[][] convertAdjacencyListToIncidenceMatrix(ArrayList<SuperNode> adjacencyList, int size) {
        int[][] incidenceMatrix = new int[size][countEdgesInAdjacencyList(adjacencyList)];
        int k = 0;

        for (SuperNode node: adjacencyList) {
            for (SuperNode neighbourhood: node.getNeighbourhoods()) {
                incidenceMatrix[node.getIndex()][k]++;
                incidenceMatrix[neighbourhood.getIndex()][k]++;
                k++;
            }
        }

        return incidenceMatrix;
    }

    // EdgesList converting
    private static int countNodesInEdgesList(ArrayList<Edge> edgesList) {
        int num = 0;

        ArrayList<SuperNode> nodes = new ArrayList<>();

        for (Edge edge: edgesList) {
            if (nodes.contains(edge.getHead())) {
                num++;
                nodes.add(edge.getHead());
            }
            if (nodes.contains(edge.getTail())) {
                num++;
                nodes.add(edge.getTail());
            }

        }

        return num;
    }

    public static int[][] convertEdgesListToAdjacencyMatrix(ArrayList<Edge> edgesList) {
        int[][] adjacencyMatrix = new int[countNodesInEdgesList(edgesList)][countNodesInEdgesList(edgesList)];

        for (Edge edge: edgesList) {
            adjacencyMatrix[edge.getHead().getIndex()][edge.getTail().getIndex()] = 1;
        }

        return adjacencyMatrix;
    }

    public static int[][] convertEdgesListToIncidenceMatrix(ArrayList<Edge> edgesList) {
        int[][] incidenceMatrix = new int[countNodesInEdgesList(edgesList)][edgesList.size()];
        int k = 0;

        for (Edge edge: edgesList) {
            incidenceMatrix[edge.getHead().getIndex()][k]++;
            incidenceMatrix[edge.getTail().getIndex()][k]++;
            k++;
        }

        return incidenceMatrix;
    }

    public static ArrayList<SuperNode> convertEdgesListToAdjacencyList(ArrayList<Edge> edgesList) {
        ArrayList<SuperNode> adjacencyList = new ArrayList<>();

        for (Edge edge: edgesList) {
            if (!adjacencyList.contains(edge.getHead())) {
                adjacencyList.add(edge.getHead());
            }
        }

        return adjacencyList;
    }

    // AdjacencyMatrix converting
    public static ArrayList<Edge> convertAdjacencyMatrixToEdgesList(int[][] adjacencyMatrix) {
        ArrayList<Edge> edgesList = new ArrayList<>();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    edgesList.add(new Edge(new SuperNode(i), new SuperNode(j)));
                }
            }
        }

        return edgesList;
    }

    private static int countEdgesInAdjacencyMatrix(int[][] adjacencyMatrix) {
        int cnt = 0;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static int[][] convertAdjacencyMatrixToIncidenceMatrix(int[][] adjacencyMatrix) {
        int[][] incidenceMatrix = new int[adjacencyMatrix.length][countEdgesInAdjacencyMatrix(adjacencyMatrix)];
        int k = 0;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    incidenceMatrix[i][k]++;
                    incidenceMatrix[j][k]++;
                    k++;
                }
            }
        }


        return incidenceMatrix;
    }

    public static ArrayList<SuperNode> convertAdjacencyMatrixToAdjacencyList() {
        ArrayList<SuperNode> adjacencyList = new ArrayList<>();

        for (int i = 0; i < adjacencyList.size(); i++) {
            SuperNode node = new SuperNode(i);
            for (int j = 0; j < adjacencyList.size(); j++) {
                node.addNeighbourhood(new SuperNode(j));
            }
        }

        return adjacencyList;
    }

    // incidenceMatrix converting
    public static ArrayList<Edge> convertIncidenceMatrixToEdgesList(int[][] incidenceMatrix) {
        ArrayList<Edge> edgesList = new ArrayList<>();

        for (int i = 0; i < incidenceMatrix[0].length; i++) {
            Edge edge = new Edge();

            for (int j = 0; j < incidenceMatrix.length; j++) {
                if (incidenceMatrix[i][j] == 2) {
                    edge.setHead(new SuperNode(j));
                    edge.setTail(new SuperNode(j));
                }
                if (incidenceMatrix[i][j] == 1) {
                    if (edge.getHead() == null) {
                        edge.setHead(new SuperNode(j));
                    } else {
                        edge.setTail(new SuperNode(j));
                    }
                }
            }

            edgesList.add(edge);
        }

        return edgesList;
    }

    public static int[][] convertIncidenceMatrixToAdjacencyMatrix(int[][] incidenceMatrix) {
        int[][] adjacencyMatrix = new int[incidenceMatrix.length][];

        for (int i = 0; i < incidenceMatrix[0].length; i++) {
            Edge edge = new Edge();

            for (int j = 0; j < incidenceMatrix.length; j++) {
                if (incidenceMatrix[i][j] == 2) {
                    edge.setHead(new SuperNode(j));
                    edge.setTail(new SuperNode(j));
                }
                if (incidenceMatrix[i][j] == 1) {
                    if (edge.getHead() == null) {
                        edge.setHead(new SuperNode(j));
                    } else {
                        edge.setTail(new SuperNode(j));
                    }
                }
            }

            adjacencyMatrix[edge.getHead().getIndex()][edge.getTail().getIndex()] = 1;
        }

        return adjacencyMatrix;
    }

    public static ArrayList<SuperNode> convertIncidenceMatrixToAdjacencyList(int[][] incidenceMatrix) {
        ArrayList<SuperNode> adjacencyList = new ArrayList<>();

        for (int i = 0; i < incidenceMatrix.length; i++) {
            SuperNode node = new SuperNode(i);

            for (int j = 0; j < incidenceMatrix[0].length; j++) {
                if (incidenceMatrix[i][j] == 2) {
                    node.addNeighbourhood(new SuperNode(i));
                }
                if (incidenceMatrix[i][j] == 1) {
                    for (int k = 0; k < incidenceMatrix.length; k++) {
                        if (incidenceMatrix[k][j] == 1 && k != i) {
                            node.addNeighbourhood(new SuperNode(k));
                        }
                    }
                }
            }

            adjacencyList.add(node);
        }

        return adjacencyList;
    }

}
