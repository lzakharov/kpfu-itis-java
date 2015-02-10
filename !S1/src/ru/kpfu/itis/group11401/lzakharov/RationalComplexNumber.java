package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

public class RationalComplexNumber {
    private RationalFraction re, im;

    public RationalComplexNumber() {
        this(new RationalFraction(), new RationalFraction());
    }

    public RationalComplexNumber(RationalFraction re, RationalFraction im) {
        this.re = re;
        this.im = im;
    }

    public RationalComplexNumber add(RationalComplexNumber a) {
        RationalComplexNumber res = new RationalComplexNumber(this.re.add(a.re), this.im.add(a.im));
        return res;
    }

    public RationalComplexNumber sub(RationalComplexNumber a) {
        RationalComplexNumber res = new RationalComplexNumber(this.re.sub(a.re), this.im.sub(a.im));
        return res;
    }

    public RationalComplexNumber mult(RationalComplexNumber a) {
        RationalComplexNumber res = new RationalComplexNumber();
        res.re = this.re.mult(a.re).sub(this.im.mult(a.im));
        res.im = this.re.mult(a.im).add(this.im.mult(a.re));

        return res;
    }

    public String toString() {
        String res = this.re.toString();
        if (this.im.getA() < 0) {
            return this.re.toString() + " - " + (-1) * this.im.getA() + "/" + this.im.getB() + " * i";
        } else {
            return this.re.toString() + " + " + this.im.getA() + "/" + this.im.getB() + " * i";
        }
    }
}
