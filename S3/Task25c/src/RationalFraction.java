/**
 * @author Lev Zakharov
 * 11401
 * Created on 17.11.2014.
 */

public class RationalFraction {
    private int a, b;

    @Author(name = "Lev")
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        this.reduce();
    }

    @Author(name = "Lev")
    public int getB() {
        return b;
    }

    @Author(name = "Lev")
    public void setB(int b) {
        this.b = b;
        this.reduce();
    }

    @Author(name = "Lev")
    public RationalFraction() {
        this(0, 0);
    }

    @Author(name = "Lev")
    public RationalFraction(int a, int b) {
        this.a = a;
        this.b = b;
        this.reduce();
    }

    @Author(name = "Lev")
    private static int gcd(int x, int y) {
        if (x != 0) {
            return gcd(y % x, x);
        } else {
            return y;
        }
    }

    @Author(name = "Edik")
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

    @Author(name = "Edik")
    public RationalFraction add(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.b + x.a * this.b;
        res.b = this.b * x.b;
        res.reduce();
        return res;
    }

    @Author(name = "Edik")
    public void add2(RationalFraction x) {
        this.a = this.a * x.b + x.a * this.b;
        this.b *= x.b;
        this.reduce();
    }

    @Author(name = "Roma")
    public RationalFraction sub(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.b - x.a * this.b;
        res.b = this.b * x.b;
        res.reduce();
        return res;
    }

    @Author(name = "Roma")
    public void sub2(RationalFraction x) {
        this.a = this.a * x.b - x.a * this.b;
        this.b *= x.b;
        this.reduce();
    }

    @Author(name = "Roma")
    public RationalFraction mult(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.a;
        res.b = this.b * x.b;
        res.reduce();
        return res;
    }

    @Author(name = "Nail")
    public void mult2(RationalFraction x) {
        this.a *= x.a;
        this.b *= x.b;
        this.reduce();
    }

    @Author(name = "Nail")
    public RationalFraction div(RationalFraction x) {
        RationalFraction res = new RationalFraction();
        res.a = this.a * x.b;
        res.b = this.b * x.a;
        res.reduce();
        return res;
    }

    @Author(name = "Nail")
    public void div2(RationalFraction x) {
        this.a *= x.b;
        this.b *= x.a;
        this.reduce();
    }

    @Author(name = "Nikita")
    public String toString() {
        return this.a + "/" + this.b;
    }

    @Author(name = "Nikita")
    public boolean equals(RationalFraction x) {
        RationalFraction a = new RationalFraction(this.a, this.b);
        RationalFraction b = new RationalFraction(x.a, x.b);

        if ((a.a == b.a) && (a.b == b.b)) {
            return true;
        } else {
            return false;
        }
    }

    @Author(name = "Lev")
    public int numberPart() {
        return (int)(this.a / this.b);
    }
}
