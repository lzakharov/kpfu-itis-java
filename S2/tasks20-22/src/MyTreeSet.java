import java.util.*;

/**
 * Created by lzakharov on 16.04.15.
 */
public class MyTreeSet<T extends Comparable<T>> implements Set<T> {
    private BSTNode<T> root;
    private int size;

    public MyTreeSet() {
        root = null;
        size = 0;
    }

    public MyTreeSet(BSTNode<T> root) {
        root = root;
        size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private BSTNode<T> search(BSTNode<T> node, BSTNode<T> required) {
        if (node == null || node.equals(required)) {
            return node;
        } else if (node.compareTo(required) > 0) {
            return search(node.getLeft(), required);
        } else {
            return search(node.getRight(), required);
        }
    }

    @Override
    public boolean contains(Object o) {
        return this.search(root, (BSTNode<T>)o) != null;
    }

    private BSTNode<T> minimum(BSTNode<T> node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return minimum(node.getLeft());
        }
    }

    private BSTNode<T> maximum(BSTNode<T> node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return minimum(node.getRight());
        }
    }

    private BSTNode<T> getNext(BSTNode<T> node) {
        if (node.getRight() != null) {
            return minimum(node.getRight());
        } else {
            BSTNode<T> parent = node.getParent();
            while (parent != null && node == parent.getRight()) {
                node = parent;
                parent = parent.getParent();
            }

            return parent;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            BSTNode<T> current = root;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                current = getNext(current);
                return current.getValue();
            }
        };
    }

    @Override
    public Object[] toArray() {
        Queue<BSTNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        Object[] objects = new Object[size];
        int i = 0;

        while (!queue.isEmpty()) {
            BSTNode<T> node = queue.remove();
            objects[i] = node.getValue();
            i++;

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }

        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[])toArray();
        } else {
            Queue<BSTNode<T>> queue = new LinkedList<>();
            queue.offer(root);
            int i = 0;

            while (!queue.isEmpty()) {
                BSTNode<T> node = queue.remove();
                a[i] = (T1)node.getValue();
                i++;

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }

            return a;
        }
    }


    private boolean addNode(BSTNode<T> node, T value) {
        if (node.getValue().compareTo(value) > 0) {
            if (node.getRight() != null) {
                addNode(node.getRight(), value);
                return true;
            } else {
                node.setRight(new BSTNode<T>(value, node));
            }
        } else {
            if (node.getLeft() != null) {
                addNode(node.getLeft(), value);
                return true;
            } else {
                node.setLeft(new BSTNode<T>(value, node));
            }
        }

        return false;
    }

    @Override
    public boolean add(T t) {
        return addNode(root, t);
    }

    private boolean removeNode(BSTNode<T> z) {
        if (!this.contains(z)) {
            return false;
        }
        BSTNode<T> x, y;
        // Определяем вершину y, которую впоследствии вырежем
        if (z.getLeft() == null || z.getRight() == null) {
            y = z;
        } else {
            y = getNext(z);
        }

        // x - ребенок вершины y
        if (y.getLeft() != null) {
            x = y.getLeft();
        } else {
            x = y.getRight();
        }

        // вырезаем y
        if (x != null) {
            x.setParent(y);
        }

        if (y.getParent() == null) {
            root = x;
        } else {
            if (y.getParent().getLeft().compareTo(y) == 0) {
                y.getParent().setLeft(x);
            } else {
                y.getParent().setRight(x);
            }
        }

        if (y.compareTo(z) != 0) {
            z.setValue(y.getValue());
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return removeNode((BSTNode<T>)o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean res = true;
        Iterator<?> iterator = c.iterator();

        while (iterator.hasNext()) {
            res &= contains(iterator.next());
        }

        return res;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean res = true;
        Iterator<? extends T> iterator = c.iterator();

        while (iterator.hasNext()) {
            res &= add(iterator.next());
        }

        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Queue<BSTNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BSTNode<T> node = queue.remove();
            if (!c.contains(node)) {
                this.remove(node);
            }

            if (node.getLeft() != null) {
                queue.offer(node);
            }
            if (node.getRight() != null) {
                queue.offer(node);
            }
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = true;
        Iterator<?> iterator = c.iterator();

        while (iterator.hasNext()) {
            res &= remove(iterator);
        }

        return res;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
}
