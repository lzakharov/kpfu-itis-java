/**
 * Created by lzakharov on 19.02.15.
 */
public class Monomial {
    private int factor;
    private int power;
    private Monomial next;

    public Monomial(int factor, int power) {
        this.factor = factor;
        this.power = power;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Monomial getNext() {
        return next;
    }

    public void setNext(Monomial next) {
        this.next = next;
    }
}
