package ru.kpfu.itis.group11401.lzakharov;

/**
 * Created by lzakharov on 26.02.15.
 */
public interface MyStack<T> {
    public void push(T x);
    public T pop();
    public boolean isEmpty();
    public T peek();
}
