package ru.kpfu.itis.group11401.lzakharov;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by lzakharov on 08.03.15.
 */
public class MyLinkedCollection implements Collection<Integer> {
    protected Elem<Integer> head;
    protected Elem<Integer> tail;
    protected int size;

    public MyLinkedCollection() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Elem<Integer> getHead() {
        return head;
    }

    public void setHead(Elem<Integer> head) {
        this.head = head;
    }

    public Elem<Integer> getTail() {
        return tail;
    }

    public void setTail(Elem<Integer> tail) {
        this.tail = tail;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Elem<Integer> p = this.head;
        while (p != null) {
            if (p.getValue().equals(o)) {
                return true;
            }

            p = p.getNext();
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        Elem<Integer> p = new Elem<Integer>(integer);

        if (this.isEmpty()) {
            this.head = p;
            this.tail = p;
        } else {
            this.tail.setNext(p);
            this.tail = p;
        }

        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Elem<Integer> p = this.head;
        while (p.getNext() != null) {
            if (p.getNext().getValue().equals(o)) {
                p.setNext(p.getNext().getNext());
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object x: c) {
            if (!this.contains(x)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean flag = true;
        for (Integer x: c) {
            flag = flag && this.add(x);
        }

        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (Object x: c) {
            flag = flag || this.remove(x);
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        this.clear();
        for (Object x: c) {
            this.add((Integer)x);
        }

        return flag;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
