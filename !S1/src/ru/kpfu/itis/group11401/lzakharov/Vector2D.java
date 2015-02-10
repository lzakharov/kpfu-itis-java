package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 * Created on 13.11.2014.
 */

public class Vector2D {
    private double x, y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Vector2D add(Vector2D v) {
        Vector2D res = new Vector2D(this.x + v.x, this.y + v.y);
        return res;
    }

    public void add2(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
    }


    public Vector2D sub(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public void sub2(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public Vector2D mult(double k) {
        return new Vector2D(this.x * k, this.y * k);
    }

    public void mult2(double k) {
        this.x *= k;
        this.y *= k;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarProduct(Vector2D v) {
        return this.x * v.x + this.y + v.y;
    }

    public double cos(Vector2D v) {
        return this.scalarProduct(v) / (this.length() * v.length());
    }

    public boolean equals(Vector2D v) {
        return ((this.x == v.x) && (this.y == v.y));
    }
}
