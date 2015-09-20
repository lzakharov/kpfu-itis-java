/**
 * Created by lzakharov on 10.05.15.
 */
public class SumThread implements Runnable {
    private int[] data;
    private int left;
    private int right;
    private volatile static int sum = 0;

    public SumThread(int[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printSum() {
        System.out.println(sum);
    }

    @Override
    public void run() {
        for (int i = left; i < right; i++) {
            sum += data[i];
        }
    }
}
