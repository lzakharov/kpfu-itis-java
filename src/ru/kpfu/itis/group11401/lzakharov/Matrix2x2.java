package ru.kpfu.itis.group11401.lzakharov;/**
 * @author Lev Zakharov
 * 11401
 * Created on 18.11.2014.
 */

public class Matrix2x2 {
    double[][] matrix = new double[2][2];

    public Matrix2x2() {
        this(0);
    }

    public Matrix2x2(double x) {
        this(x, x, x, x);
    }

    public Matrix2x2(double x0, double x1, double x2, double x3) {
        this.matrix[0][0] = x0;
        this.matrix[0][1] = x1;
        this.matrix[1][0] = x2;
        this.matrix[1][1] = x3;
    }

    public Matrix2x2(double[][] matrix) {
        this.matrix = matrix;
    }

    public double get(int i, int j) {
        return this.matrix[i][j];
    }

    public void set(int i, int j, int x) {
        this.matrix[i][j] = x;
    }

    public Matrix2x2 add(Matrix2x2 x) {
        Matrix2x2 res = new Matrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j] + x.matrix[i][j];
            }
        }

        return res;
    }

    public void add2(Matrix2x2 x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] += x.matrix[i][j];            
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 x) {
        Matrix2x2 res = new Matrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j] - x.matrix[i][j];
            }
        }

        return res;
    }

    public void sub2(Matrix2x2 x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] -= x.matrix[i][j];            
            }
        }
    }

    public Matrix2x2 multNumber(double k) {
        Matrix2x2 res = new Matrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j] * k;
            }
        }

        return res;
    } 

    public void multNumber2(double k) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] *= k;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 a) {
        Matrix2x2 res = new Matrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = 0;
                for (int k = 0; j < 2; k++) {
                    res.matrix[i][j] += this.matrix[i][k] * a.matrix[k][j];
                }
            }
        }

        return res;
    }

    public void mult2(Matrix2x2 a) {
        this.matrix = this.mult(a).matrix;
    }

    public double det() {
        return this.matrix[0][0] * this.matrix[1][1] - this.matrix[1][0] * this.matrix[0][1];
    }

    private void swap(int a, int b, int x, int y) {
        double k = this.matrix[a][b];
        this.matrix[a][b] = this.matrix[x][y];
        this.matrix[x][y] = k;
    }

    public void transpon() {
        this.swap(0, 1, 1, 0);
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 res = new Matrix2x2(this.matrix[1][1], (-1) * this.matrix[1][0], (-1) * this.matrix[0][1], this.matrix[0][0]);
        double det = this.det();

        if (det == 0) {
            System.out.println("Error");
            return new Matrix2x2();
        }

        res.transpon();
        res.multNumber2(1.0 / det);

        return res;
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 res = new Matrix2x2(this.matrix);

        res.matrix[1][1] /= res.matrix[1][0];
        res.matrix[1][1] *= res.matrix[0][0];
        res.matrix[1][1] -= res.matrix[0][1];
        res.matrix[1][0] = 0;

        res.matrix[0][0] /= res.matrix[0][1];
        res.matrix[0][0] *= res.matrix[1][1];
        res.matrix[0][1] = 0;

        return res;
    }

    public Vector2D multVector(Vector2D x) {
        return new Vector2D(x.getX() * this.matrix[0][0] + x.getY() * this.matrix[1][0], x.getX() * this.matrix[0][1] + x.getY() * this.matrix[1][1]);
    }
}
