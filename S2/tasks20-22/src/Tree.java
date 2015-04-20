import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lzakharov on 15.04.15.
 */
public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public int sumBFS() {
        int sum = 0;
        Queue<Node<T>> queue = new LinkedList<>();

        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            sum += (Integer)node.getValue();

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }

        return sum;
    }

    public int multDFS(Node<T> node) {
        if (!node.hasSons()) {
            return (Integer)node.getValue();
        }
        if (node.hasSons()) {
            return (Integer)multDFS(node.getLeft()) * (Integer)multDFS(node.getRight()) * (Integer)node.getValue();
        } else if (node.getLeft() != null) {
            return (Integer)multDFS(node.getLeft()) * (Integer)node.getValue();
        } else {
            return (Integer)multDFS(node.getRight()) * (Integer)node.getValue();
        }
    }

    public int maxStackDFS() {
        int max = (Integer)this.root.getValue();
        Stack<Node<T>> stack = new Stack<>();

        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            max = Math.max(max, (Integer)node.getValue());

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }

        return max;
    }

    public void stackLKP() {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node<T> node = stack.peek();
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            } else {
                stack.pop();
                System.out.println(node);
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
            }
        }
    }

    public void stackLPK() {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node<T> node = stack.peek();
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            } else if (node.getRight() != null) {
                stack.push(node.getRight());
            } else {
                System.out.println(stack.pop());
            }
        }
    }
}
