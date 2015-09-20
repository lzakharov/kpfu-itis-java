/**
 * Created by lzakharov on 06.05.15.
 */
public class Edge {
    private SuperNode head;
    private SuperNode tail;

    public Edge() {
    }

    public Edge(SuperNode head, SuperNode tail) {
        this.head = head;
        this.tail = tail;
    }

    public void setHead(SuperNode head) {
        this.head = head;
    }

    public void setTail(SuperNode tail) {
        this.tail = tail;
    }

    public SuperNode getHead() {
        return head;
    }

    public SuperNode getTail() {
        return tail;
    }
}
