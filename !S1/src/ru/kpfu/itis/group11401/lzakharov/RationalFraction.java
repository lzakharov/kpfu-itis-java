package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 * Created on 17.11.2014.
 */

public class RationalFraction {
    private int a, b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        this.reduce();
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
        this.reduce();
    }

    public RationalFraction() {
        this(0, 0);
    }

    public RationalFraction(int a, int b) {
        this.a = a;
        this.b = b;
        this.reduce();
    }

    private static int gcd(int x, int y) {
        if (x != 0) {
            return gcd(y % x, x);
        } else {
            return y;
        }
    }

    public void reduce() {
        if (this.b < 0) {
            this.a *= -1;
            this.b *= -1;
        }
        
        int gcd = this.gcd(this.a, this.b);
        if (gcd != 0) {
            this.a /= gcd;
            this.b /= gcd;
        }

    }

    public RationalFraction add(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.b + x.a * this.b;
        res.b = this.b * x.b;
        res.reduce();
        return res;
    }

    public void add2(RationalFraction x) {
        this.a = this.a * x.b + x.a * this.b;
        this.b *= x.b;
        this.reduce();
    }

    public RationalFraction sub(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.b - x.a * this.b;
        res.b = this.b * x.b;
        res.reduce();
        return res;
    }

    public void sub2(RationalFraction x) {
        this.a = this.a * x.b - x.a * this.b;
        this.b *= x.b;
        this.reduce();
    }

    public RationalFraction mult(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.a;
        res.b = this.b * x.b;
        res.reduce();
        return res;
    }

    public void mult2(RationalFraction x) {
        this.a *= x.a;
        this.b *= x.b;
        this.reduce();
    }

    public RationalFraction div(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.b;
        res.b = this.b * x.a;
        res.reduce();
        return res;
    }

    public void div2(RationalFraction x) {
        this.a *= x.b;
        this.b *= x.a;
        this.reduce();
    }

    public String toString() {
        return this.a + "/" + this.b;
    }

    public boolean equals(RationalFraction x) {
        RationalFraction a = new RationalFraction(this.a, this.b);
        RationalFraction b = new RationalFraction(x.a, x.b);

        if ((a.a == b.a) && (a.b == b.b)) {
            return true;
        } else {
            return false;
        }
    }

    public int numberPart() {
        return (int)(this.a / this.b);
    }
}
