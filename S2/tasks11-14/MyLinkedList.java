package ru.kpfu.itis.group11401.lzakharov;

import java.util.*;
import java.util.List;

/**
 * Created by lzakharov on 08.03.15.
 */
public class MyLinkedList extends MyLinkedCollection implements java.util.List<Integer>{
    public MyLinkedList() {
        super();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        Elem<Integer> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }
        MyLinkedCollection x = new MyLinkedList();
        for (Integer e: c) {
            x.add(e);
        }

        x.getTail().setNext(p.getNext());
        p.setNext(x.getHead());
        return true;
    }

    @Override
    public Integer get(int index) {
        Elem<Integer> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }
        return p.getValue();
    }

    @Override
    public Integer set(int index, Integer element) {
        Elem<Integer> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }

        Integer res = p.getValue();
        p.setValue(element);

        return res;
    }

    @Override
    public void add(int index, Integer element) {
        Elem<Integer> p = this.head;
        while (index > 0) {
            index--;
            p = p.getNext();
        }
        Elem<Integer> x = new Elem<Integer>(element);
        x.setNext(p.getNext());
        p.setNext(x);
    }

    @Override
    public Integer remove(int index) {
        Elem<Integer> p = this.head;
        while (index > 1) {
            index--;
            p = p.getNext();
        }
        Integer res = p.getNext().getValue();
        p.setNext(p.getNext().getNext());
        return res;
    }

    @Override
    public int indexOf(Object o) {
        Elem<Integer> p = this.head;
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
        Elem<Integer> p = this.head;
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
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        int i = 0;
        Elem<Integer> p = this.head;
        while (i < fromIndex) {
            p = p.getNext();
            i++;
        }

        List<Integer> res = new ArrayList<>();

        while (i < toIndex) {
            res.add(p.getValue());
            p = p.getNext();
            i++;
        }
        return res;
    }
}
