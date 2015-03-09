package ru.kpfu.itis.group11401.lzakharov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by lzakharov on 08.03.15.
 */
public class MyList<T> extends MyCollection<T> implements java.util.List<T> {

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Elem<T> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }
        MyCollection<T> x = new MyCollection<>();
        for (T e: c) {
            x.add(e);
        }

        x.getTail().setNext(p.getNext());
        p.setNext(x.getHead());
        return true;
    }

    @Override
    public T get(int index) {
        Elem<T> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }
        return p.getValue();
    }

    @Override
    public T set(int index, T element) {
        Elem<T> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }

        T res = p.getValue();
        p.setValue(element);

        return res;
    }

    @Override
    public void add(int index, T element) {
        Elem<T> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }
        Elem<T> x = new Elem<T>(element);
        x.setNext(p.getNext());
        p.setNext(x);
    }

    @Override
    public T remove(int index) {
        Elem<T> p = this.head;
        while (index > 1) {
            index--;
            p = p.getNext();
        }
        T res = p.getNext().getValue();
        p.setNext(p.getNext().getNext());
        return res;
    }

    @Override
    public int indexOf(Object o) {
        Elem<T> p = this.head;
        int res = -1;
        while (p != null) {
            if (p.getValue().equals(o)) {
                return res;
            }
            res++;
            p = p.getNext();
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Elem<T> p = this.head;
        int res = -1;
        int i = 0;
        while (p != null) {
            if (p.getValue().equals(o)) {
                res = i;
            }

            i++;
            p = p.getNext();
        }

        return res;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        int i = 0;
        Elem<T> p = this.head;
        while (i < fromIndex) {
            p = p.getNext();
            i++;
        }

        List<T> res = new ArrayList<>();

        while (i < toIndex) {
            res.add(p.getValue());
            p = p.getNext();
            i++;
        }
        return res;
    }
}
