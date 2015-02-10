package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 * Created on 13.11.2014.
 */

public class ComplexNumber {
    private double re, im;
    private static int total = 0;

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
        total++;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getRe() {
        return this.re;
    }

    public double getIm() {
        return this.im;
    }

    public int getTotal() {
    	return total;
    }

    public String toString() {
        if (this.im == 0) {
            if (this.re == 0) {
                return "0";
            } else {
                return this.re + "";
            }
        } else {
            if (this.re == 0) {
                return this.im + " * i";
            } else {
                return this.re + " + " + this.im + " * i";
            }
        }
    }

    public ComplexNumber add(ComplexNumber x) {
        ComplexNumber res = new ComplexNumber();
        res.re = this.re + x.re;
        res.im = this.im + x.im;

        return res;
    }

    public void add2(ComplexNumber x) {
        this.re += x.re;
        this.im += x.im;
    }

    public ComplexNumber sub(ComplexNumber x) {
        ComplexNumber res = new ComplexNumber();
        res.re = this.re - x.re;
        res.im = this.im - x.im;

        return res;
    }

    public void sub2(ComplexNumber x) {
        this.re -= x.re;
        this.im -= x.im;
    }

    public ComplexNumber mult(ComplexNumber x) {
        ComplexNumber res = new ComplexNumber();
        res.re = this.re * x.re - this.im * x.im;
        res.im = this.re * x.im + this.im * x.re;

        return res;
    }

    public void mult2(ComplexNumber x) {
        this.re = this.re * x.re - this.im * x.im;
        this.im = this.re * x.im + this.im * x.re;
    }

    public ComplexNumber div(ComplexNumber x) {
        ComplexNumber res = new ComplexNumber();
        double denominator = x.re * x.re + x.im * x.im;
        res.re = (this.re * x.re + this.im * x.im) / denominator;
        res.im = (this.re * x.im - this.im * x.re) / denominator;

        return res;
    }

    public void div2(ComplexNumber x) {
        double denominator = x.re * x.re + x.im * x.im;
        this.re = (this.re * x.re + this.im * x.im) / denominator;
        this.im = (this.re * x.im - this.im * x.re) / denominator;
    }

    public double length() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    public double cos() {
        return this.re / (this.length());
    }

    public double sin() {
        return this.im / (this.length());
    }

    public double arg() {
        return Math.acos(this.cos());
    }

    public boolean equals(ComplexNumber x) {
        if ((this.re == x.re) && (this.im == x.im)) {
            return true;
        } else {
            return false;
        }
    }

    private double doublePow(double x, int a) {
    	double res = 1;
    	for (int i = 0; i < a; i++) {
    		res *= x;
    	}

    	return res;
    }

    public ComplexNumber complexNumberPow(int a) {
    	ComplexNumber res = new ComplexNumber();
    	double r = doublePow(this.length(), a);
        double fi = a * this.arg();
    	res.re = r * Math.cos(fi);
    	res.im = r * Math.sin(fi);

    	return res;
    }

    public void complexNumberPow2(int a) {
    	double r = doublePow(this.length(), a);
        double fi = a * this.arg();
    	this.re = r * Math.cos(fi);
    	this.im = r * Math.sin(fi);
    }
}
