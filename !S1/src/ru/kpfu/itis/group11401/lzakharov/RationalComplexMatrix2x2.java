package ru.kpfu.itis.group11401.lzakharov;/**
 * @author Lev Zakharov
 * 11401
 * Created on 20.11.2014.
 */

import java.util.*;

public class RationalComplexMatrix2x2 {
    private RationalComplexNumber[][] matrix = new RationalComplexNumber[2][2];

    public RationalComplexMatrix2x2() {
        this(new RationalComplexNumber());
    }

    public RationalComplexMatrix2x2(RationalComplexNumber x) {
        this(x, x, x, x);
    }

    public RationalComplexMatrix2x2(RationalComplexNumber x0, RationalComplexNumber x1, RationalComplexNumber x2, RationalComplexNumber x3) {
        this.matrix[0][0] = x0;
        this.matrix[0][1] = x1;
        this.matrix[1][0] = x2;
        this.matrix[1][1] = x3;
    }

    public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 x) {
        RationalComplexMatrix2x2 res = new RationalComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j].add(x.matrix[i][j]);
            }
        }

        return res;
    }

    public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 a) {
        RationalComplexMatrix2x2 res = new RationalComplexMatrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = new RationalComplexNumber();
                for (int k = 0; k < 2; k++) {
                    res.matrix[i][j].add(this.matrix[i][k].mult(a.matrix[k][j]));
                }
            }
        }

        return res;
    }

    public RationalComplexNumber det() {
        return this.matrix[0][0].mult(this.matrix[1][1]).sub(this.matrix[1][0].mult(this.matrix[0][1]));
    }

    public RationalComplexVector2D multVector(RationalComplexVector2D a) {
        return new RationalComplexVector2D(this.matrix[0][0].mult(a.getX()).add(this.matrix[1][1].mult(a.getY())), this.matrix[1][0].mult(a.getX()).add(this.matrix[0][1].mult(a.getY())));
    }
}
