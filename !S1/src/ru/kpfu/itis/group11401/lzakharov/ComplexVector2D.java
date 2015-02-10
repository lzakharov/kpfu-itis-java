package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.11.2014.
 */

public class ComplexVector2D {
    private ComplexNumber x, y;

    public ComplexNumber getX() {
        return x;
    }

    public void setX(ComplexNumber x) {
        this.x = x;
    }

    public ComplexNumber getY() {
        return y;
    }

    public void setY(ComplexNumber y) {
        this.y = y;
    }

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());
    }

    public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
        this.x = x;
        this.y = y;
    }

    public ComplexVector2D add(ComplexVector2D a) {
        return new ComplexVector2D(this.x.add(a.x), this.y.add(a.y));
    }

    public String toString() {
        return "(" + this.x.toString() + ", " + this.y.toString() + ")";
    }

    public ComplexNumber scalarProduct(ComplexVector2D a) {
        return this.x.mult(a.x).add(this.y.mult(a.y));
    }

    public boolean equals(ComplexVector2D a) {
        return ((this.x.equals(a.x)) && (this.y.equals(a.y)));
    }
}
