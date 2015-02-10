package ru.kpfu.itis.group11401.lzakharov;/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import java.util.*;

public class RationalComplexVector2D {
    private RationalComplexNumber x, y;

    public RationalComplexNumber getX() {
        return x;
    }

    public void setX(RationalComplexNumber x) {
        this.x = x;
    }

    public RationalComplexNumber getY() {
        return y;
    }

    public void setY(RationalComplexNumber y) {
        this.y = y;
    }

    public RationalComplexVector2D() {
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }

    public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
        this.x = x;
        this.y = y;
    }

    public RationalComplexVector2D add(RationalComplexVector2D a) {
        return new RationalComplexVector2D(this.x.add(a.x), this.y.add(a.y));
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public RationalComplexNumber scalarProduct(RationalComplexVector2D a) {
        return this.x.mult(a.x).add(this.y.mult(a.y));
    }

}
