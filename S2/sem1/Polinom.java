import java.io.*;

/**
 * Created by lzakharov on 19.02.15.
 */

public class Polinom {
    private Monomial head;

    public Polinom() {
        this.head = null;
    }

    public Polinom(String filename) throws FileNotFoundException {
        File file = new File(filename);

        try {
            BufferedReader input = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = input.readLine()) != null) {
                String[] t = s.split(" ");
                this.insert(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Monomial getHead() {
        return head;
    }

    public void setHead(Monomial head) {
        this.head = head;
    }

    public String toString() {
        Monomial p = this.head;
        String res = p.getFactor() + "x^" + p.getPower();
        p = p.getNext();

        while (p != null) {
            if (p.getPower() == 0) {
                res += " + " + p.getFactor();
            } else {
                res += " + " + p.getFactor() + "x^" + p.getPower();
            }
            p = p.getNext();
        }

        return res;
    }

    public void insert(int factor, int power) {
        Monomial monomial = new Monomial(factor, power);
        Monomial p = this.head;

        if (p == null) {
            monomial.setNext(p);
            this.setHead(monomial);
        } else if (monomial.getPower() > p.getPower()) {
            monomial.setNext(p);
            this.setHead(monomial);
        } else {
            while (p.getNext() != null && p.getNext().getPower() > monomial.getPower()) {
                p = p.getNext();
            }

            if (p.getNext() == null) {
                p.setNext(monomial);
            } else if (p.getNext().getPower() == monomial.getPower()) {
                p.getNext().setFactor(p.getNext().getFactor() + monomial.getFactor());
            } else {
                monomial.setNext(p.getNext());
                p.setNext(monomial);
            }

        }

    }

    public void delete(int deg) {
        Monomial p = this.head;

        if (p.getPower() == deg) {
            this.setHead(p.getNext());
        } else {
            while (p.getNext().getPower() != deg) {
                p = p.getNext();
            }

            if (p.getNext() == null) {
                p.setNext(null);
            } else {
                p.setNext(p.getNext().getNext());
            }
        }

    }

    public void derivate() {
        Polinom derivative = new Polinom();
        Monomial p = this.head;

        while (p != null) {
            p.setFactor(p.getFactor() * p.getPower());
            p.setPower(p.getPower() - 1);
            if (p.getNext() != null && p.getNext().getPower() == 0) {
                p.setNext(null);
            }
            p = p.getNext();
        }

    }

    public int value(int x) {
        Monomial p = this.head;
        int res = 0;
        int i = p.getPower();

        while (i > 0) {
            if (p.getPower() == i) {
                res = (res + p.getFactor()) * x;
                i--;
                p = p.getNext();
            } else {
                res *= x;
                i--;
            }
        }

        return res + p.getFactor();
    }

    public void deleteOdd() {
        Monomial p = head;

        while (p != null) {
            if (p.getFactor() % 2 == 1) {
                this.delete(p.getPower());
            }
            p = p.getNext();
        }
    }

    public void sum(Polinom p) {
        Monomial x = p.getHead();

        while (x != null) {
            this.insert(x.getFactor(), x.getPower());
            x = x.getNext();
        }
    }

    public void combine() {
    }
}
