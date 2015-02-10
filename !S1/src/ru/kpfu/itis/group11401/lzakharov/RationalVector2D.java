package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 */

public class RationalVector2D {
	private RationalFraction x, y;

    public RationalFraction getX() {
        return x;
    }

    public void setX(RationalFraction x) {
        this.x = x;
    }

    public RationalFraction getY() {
        return y;
    }

    public void setY(RationalFraction y) {
        this.y = y;
    }

    public RationalVector2D() {
        this(new RationalFraction(), new RationalFraction());
    }

	public RationalVector2D(RationalFraction x, RationalFraction y) {
		this.x = x;
		this.y = y;
	}

	public RationalVector2D add(RationalVector2D a) {
        return new RationalVector2D(this.x.add(a.x), this.y.add(a.y));
	}

    public String toString() {
        return "(" + this.x.toString() + ", " + this.y.toString() + ")";
    }

    public double length() {
        return Math.sqrt(this.x.getA() * this.x.getA() / (this.x.getB() * this.x.getB()) + this.y.getA() * this.y.getA() / (this.y.getB() * this.y.getB()));
    }

    public RationalFraction scalarProduct(RationalVector2D a) {
        return this.x.mult(a.x).add(this.y.mult(a.y));
    }

    public boolean equals(RationalVector2D a) {
        return ((this.x.equals(a.x)) && (this.y.equals(a.y)));
    }
}