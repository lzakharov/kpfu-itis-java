import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lzakharov on 11.11.15.
 */

public class Calculator extends JFrame {
    private JTextArea res;
    private double x = 0;
    private int oper = 1;

    private JButton add, sub, mult, div, comma, enter, del;

    public Calculator(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GroupLayout(getContentPane()));
        this.setBounds(400, 100, 320, 420);

        res = new JTextArea("0");
        Font font = new Font("Arials", Font.BOLD, 48);
        res.setFont(font);
        res.setBounds(0, 0, 240, 80);
        res.setEditable(false);
        this.add(res);


        for (int i = 1; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.setName(Integer.toString(i));
            button.setBounds(((i - 1) % 3) * 80, ((i - 1) / 3) * 80 + 80, 80, 80);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (res.getText().equals("0"))
                        res.setText("");
                    if (res.getText().length() < 9) {
                        res.append(((JButton) e.getSource()).getName());
                    }
                }
            });
            this.add(button);
        }

        JButton nil = new JButton("0");
        nil.setBounds(0, 320, 80, 80);
        nil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!res.getText().equals("0")) {
                    res.append("0");
                }
            }
        });
        add = new JButton("+");
        add.setBounds(240, 80, 80, 80);
        sub = new JButton("-");
        sub.setBounds(240, 160, 80, 80);
        mult = new JButton("*");
        mult.setBounds(240, 240, 80, 80);
        div = new JButton("/");
        div.setBounds(240, 320, 80, 80);
        comma = new JButton(",");
        comma.setBounds(80, 320, 80, 80);
        enter = new JButton("=");
        enter.setBounds(160, 320, 80, 80);
        del = new JButton("del");
        del.setBounds(240, 0, 80, 80);


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = Double.parseDouble(res.getText());
                res.setText("");
                oper = 1;
            }
        });

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = Double.parseDouble(res.getText());
                res.setText("");
                oper = 2;
            }
        });

        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = Double.parseDouble(res.getText());
                res.setText("");
                oper = 3;
            }
        });

        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = Double.parseDouble(res.getText());
                res.setText("");
                oper = 4;
            }
        });

        comma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.append(".");
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = "";
                switch (oper) {
                    case 1:
                        ans = Double.toString(x + Double.parseDouble(res.getText()));
                        break;
                    case 2:
                        ans = Double.toString(x - Double.parseDouble(res.getText()));
                        break;
                    case 3:
                        ans = Double.toString(x * Double.parseDouble(res.getText()));
                        break;
                    case 4:
                        ans = Double.toString(x / Double.parseDouble(res.getText()));
                        break;
                }

                res.setText(ans);
            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText("0");
            }
        });

        this.add(add);
        this.add(sub);
        this.add(mult);
        this.add(div);
        this.add(comma);
        this.add(enter);
        this.add(del);
        this.add(nil);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator window = new Calculator("Calculator");

    }
}

