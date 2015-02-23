package ru.kpfu.itis.group11401.lzakharov;

/**
 * Created by lzakharov on 18.02.15.
 */
public class MultiList {
    int[] head;
    int[] next;
    int[] data;
    int cnt = 1;

    public MultiList(int hnum, int size) {
        this.head = new int[hnum];
        this.data = new int[size + 1];
        this.next = new int[size + 1];
    }

    public void add(int u, int v) {
        next[cnt] = head[u];
        data[cnt] = v;
        head[u] = cnt;
        cnt++;
    }
}
