package ru.kpfu.itis.group11401.lzakharov;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by lzakharov on 07.03.15.
 */
public class MyCollection<T> implements Collection<T> {
    protected Elem<T> head;
    protected Elem<T> tail;
    protected int size;

    public MyCollection() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Elem<T> getHead() {
        return head;
    }

    public void setHead(Elem<T> head) {
        this.head = head;
    }

    public Elem<T> getTail() {
        return tail;
    }

    public void setTail(Elem<T> tail) {
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
        Elem<T> p = this.head;

        while (p != null) {
            if (p.getValue() == (T)o) {
                return true;
            }

            p = p.getNext();
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Elem<T> x = new Elem<T>(t);
        if (this.contains(x)) {
            return false;
        }
        if (this.isEmpty()) {
            this.head = x;
            this.tail = x;
        } else {
            this.tail.setNext(x);
            this.tail = x;
        }

        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Elem<T> p = this.head;
        while (p.getNext() != null) {
            if (p.getNext().getValue() == (T)o) {
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
    public boolean addAll(Collection<? extends T> c) {
        boolean flag = true;
        for (Object x: c) {
            flag &= this.add((T)x);
        }

        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (Object x: c) {
            flag |= this.remove(x);
        }

        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        Elem<T> p = this.head;
        while (p != null) {
            if (!c.contains(p.getValue())) {
                flag |= this.remove(p.getValue());
            }
        }

        return flag;
    }

    @Override
    public void clear() {
        this.size = 0;
    }
}
