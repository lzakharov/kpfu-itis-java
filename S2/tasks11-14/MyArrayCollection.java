package ru.kpfu.itis.group11401.lzakharov;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by lzakharov on 06.03.15.
 */
public class MyArrayCollection implements Collection<Integer> {
    protected final int N = 1000000;
    protected Integer[] a;
    protected int size;

    public MyArrayCollection() {
        this.a = new Integer[N];
        this.size = 0;
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
        for(Integer x: this.a) {
            if (x.equals(o)) {
                return true;
            }
        }
        return false;
    }

    protected void rightShift(int index) {
        for (int i = this.size; i > index - 1; i--) {
            this.a[i + 1] = this.a[i];
        }

        this.size++;
    }

    protected void leftShift(int index) {
        this.size--;
        for (int i = index; i < this.size; i++) {
            this.a[i] = this.a[i + 1];
        }
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
        if (!this.contains(integer)) {
            if (size + 1 >= N) {
                return false;
            } else {
                a[size] = integer;
                size++;

                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (this.a[i] == (int) (o)) {
                rightShift(i);
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
        this.size = 0;
    }
}
