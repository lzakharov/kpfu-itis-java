/**
 * @author Lev Zakharov
 * 11401
 * Created on 13.11.2014.
 */

public class Vector2D {
    private double x, y;

    @Author(name = "Nail")
    public Vector2D() {
        this(0, 0);
    }

    @Author(name = "Nail")
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Author(name = "Nail")
    public void setX(double x) {
        this.x = x;
    }

    @Author(name = "Lev")
    public void setY(double y) {
        this.y = y;
    }

    @Author(name = "Lev")
    public double getX() {
        return this.x;
    }

    @Author(name = "Lev")
    public double getY() {
        return this.y;
    }

    @Author(name = "Edik")
    public Vector2D add(Vector2D v) {
        Vector2D res = new Vector2D(this.x + v.x, this.y + v.y);
        return res;
    }

    @Author(name = "Edik")
    public void add2(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
    }


    @Author(name = "Edik")
    public Vector2D sub(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    @Author(name = "Roma")
    public void sub2(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    @Author(name = "Roma")
    public Vector2D mult(double k) {
        return new Vector2D(this.x * k, this.y * k);
    }

    @Author(name = "Roma")
    public void mult2(double k) {
        this.x *= k;
        this.y *= k;
    }

    @Author(name = "Roma")
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Author(name = "Nikita")
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Author(name = "Nikita")
    public double scalarProduct(Vector2D v) {
        return this.x * v.x + this.y + v.y;
    }

    @Author(name = "Lev")
    public double cos(Vector2D v) {
        return this.scalarProduct(v) / (this.length() * v.length());
    }

    @Author(name = "Lev")
    public boolean equals(Vector2D v) {
        return ((this.x == v.x) && (this.y == v.y));
    }
}
