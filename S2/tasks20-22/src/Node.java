import java.util.ArrayList;

/**
 * Created by lzakharov on 15.04.15.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    protected T value;
    protected Node<T> left;
    protected Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public boolean hasSons() {
        return (this.left == null && this.right == null);
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.getValue());
    }
}
