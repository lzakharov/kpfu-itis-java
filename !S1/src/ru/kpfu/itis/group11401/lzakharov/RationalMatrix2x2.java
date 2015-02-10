package ru.kpfu.itis.group11401.lzakharov;/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.11.2014.
 */

public class RationalMatrix2x2 {
    private RationalFraction[][] matrix = new RationalFraction[2][2];

    public RationalMatrix2x2() {
        this(new RationalFraction());
    }

    public RationalMatrix2x2(RationalFraction x) {
        this(x, x, x, x);
    }

    public RationalMatrix2x2(RationalFraction x0, RationalFraction x1, RationalFraction x2, RationalFraction x3) {
        this.matrix[0][0] = x0;
        this.matrix[0][1] = x1;
        this.matrix[1][0] = x2;
        this.matrix[1][1] = x3;
    }

    public RationalMatrix2x2 add(RationalMatrix2x2 a) {
        RationalMatrix2x2 res = new RationalMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j].add(a.matrix[i][j]);
            }
        }

        return res;
    }

    public RationalMatrix2x2 mult(RationalMatrix2x2 a) {
        RationalMatrix2x2 res = new RationalMatrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = new RationalFraction();
                for (int k = 0; k < 2; k++) {
                    res.matrix[i][j].add(this.matrix[i][k].mult(a.matrix[k][j]));
                }
            }
        }

        return res;
    }

    public RationalFraction det() {
        return this.matrix[0][0].mult(this.matrix[1][1]).sub(this.matrix[1][0].mult(this.matrix[0][1]));
    }

    public RationalVector2D multVector(RationalVector2D a) {
        return new RationalVector2D(this.matrix[0][0].mult(a.getX()).add(this.matrix[1][1].mult(a.getY())), this.matrix[1][0].mult(a.getX()).add(this.matrix[0][1].mult(a.getY())));
    }

}
