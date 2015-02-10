package ru.kpfu.itis.group11401.lzakharov;/**
 * @author Lev Zakharov
 * 11401
 * Created on 19.11.2014.
 */

public class ComplexMatrix2x2 {
    private ComplexNumber[][] matrix = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber x) {
        this(x, x, x, x);
    }

    public ComplexMatrix2x2(ComplexNumber x0, ComplexNumber x1, ComplexNumber x2, ComplexNumber x3) {
        this.matrix[0][0] = x0;
        this.matrix[0][1] = x1;
        this.matrix[1][0] = x2;
        this.matrix[1][1] = x3;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 a) {
        ComplexMatrix2x2 res = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j].add(a.matrix[i][j]);
            }
        }

        return res;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 a) {
        ComplexMatrix2x2 res = new ComplexMatrix2x2();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = new ComplexNumber();
                for (int k = 0; k < 2; k++) {
                    res.matrix[i][j].add(this.matrix[i][k].mult(a.matrix[k][j]));
                }
            }
        }

        return res;
    }

    public ComplexNumber det() {
        return this.matrix[0][0].mult(this.matrix[1][1]).sub(this.matrix[1][0].mult(this.matrix[0][1]));
    }

    public ComplexVector2D multVector(ComplexVector2D a) {
        return new ComplexVector2D(this.matrix[0][0].mult(a.getX()).add(this.matrix[1][1].mult(a.getY())), this.matrix[1][0].mult(a.getX()).add(this.matrix[0][1].mult(a.getY())));
    }
}
