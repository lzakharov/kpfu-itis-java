/**
 * Created by lzakharov on 18.04.15.
 */
public class BSTNode<T extends Comparable<T>> implements Comparable<BSTNode<T>>{
    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private BSTNode<T> parent;

    public BSTNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public BSTNode(T value, BSTNode<T> parent) {
        this(value);
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    public BSTNode<T> getParent() {
        return parent;
    }

    public void setParent(BSTNode<T> parent) {
        this.parent = parent;
    }

    public boolean hasSons() {
        return (this.left == null && this.right == null);
    }


    @Override
    public int compareTo(BSTNode<T> o) {
        return value.compareTo(o.getValue());
    }
}
