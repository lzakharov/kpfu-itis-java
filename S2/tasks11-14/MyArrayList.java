package ru.kpfu.itis.group11401.lzakharov;

import java.util.*;
import java.util.List;

/**
 * Created by lzakharov on 06.03.15.
 */
public class MyArrayList extends MyArrayCollection implements java.util.List<Integer> {

    public MyArrayList() {
        super();
    }

    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index == -1) {
            return false;
        } else {
            this.remove(index);
            return true;
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        if (this.size + c.size() > N) {
            return false;
        }

        for (int i = this.size; i > index - 1; i--) {
            this.a[i + c.size()] = this.a[i];
        }
        this.size += c.size();

        int i = index;
        Iterator iterator = c.iterator();

        while (iterator.hasNext()) {
            this.a[i] = (Integer)iterator.next();
            i++;
        }

        return true;
    }

    @Override
    public Integer get(int index) {
        return this.a[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        Integer res = this.a[index];
        this.a[index] = element;
        return res;
    }

    @Override
    public void add(int index, Integer element) {
        rightShift(index);
        this.a[index] = element;
    }

    @Override
    public Integer remove(int index) {
        Integer x = this.a[index];
        leftShift(index);
        return x;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (this.a[i] == (int)(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;

        for (int i = 0; i < this.size; i++) {
            if (this.a[i] == (int)(o)) {
                index = i;
            }
        }
        return index;
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
        List<Integer> res = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            res.add(this.a[i]);
        }
        return res;
    }
}
