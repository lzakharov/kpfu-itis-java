package ru.kpfu.itis.group11401.lzakharov;

/**
 * Created by lzakharov on 26.02.15.
 */
public class MyLinkedStack<T> implements MyStack<T>{
    private Elem<T> top;

    @Override
    public void push(T x) {
        Elem<T> p = new Elem<T>(x);
        p.setNext(this.top);
        this.top = p;
    }

    @Override
    public T pop() {
        T x = this.top.getValue();
        this.top = this.top.getNext();
        return x;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public T peek() {
        return this.top.getValue();
    }
}
