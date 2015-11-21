import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * Created by lzakharov on 16.11.15.
 */

public class Minesweeper extends JFrame {
    private static final int buttonSize = 40;
    private int size;
    private int minesNumber;
    private int freeCellsCount;
    private JButton[][] field;

    public Minesweeper(int size, int minesNumber) {
        this.size = size;
        this.minesNumber = minesNumber;
        this.freeCellsCount = size * size - minesNumber;

        this.setBounds(50, 50, buttonSize * size + 100, buttonSize * size + 100);
        this.setLayout(new GroupLayout(getContentPane()));

        generateField();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private String howManyMines(int x, int y) {
        int cnt = 0;

        for (int i = -1; i < 2; i++) {
            if (x + i > -1 && x + i < size) {
                for (int j = -1; j < 2; j++) {
                    if (y + j > -1 && y + j < size) {
                        cnt += Integer.parseInt(field[x + i][y + j].getName());
                    }
                }
            }
        }

        return Integer.toString(cnt);
    }

    private void restart(boolean isWinner) {
        int messageType = JOptionPane.QUESTION_MESSAGE;
        String[] options = {"Restart", "Exit"};
        String message = isWinner ? "Congratulations!" : "You loose!";
        int code = JOptionPane.showOptionDialog(this,
                message,
                "", 0, messageType,
                null, options, "Exit");

        if (code == 0) {
            this.dispose();
            new Minesweeper(size, minesNumber);
        } else if (code == 1) {
            System.exit(0);
        }
    }

    private void generateField() {
        field = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new JButton();
                field[i][j].setEnabled(true);
                field[i][j].setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);
                field[i][j].setName("0");
                field[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        JButton button = (JButton) e.getSource();

                        if (button.isEnabled()) {
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                if (button.getText().equals("F")) {
                                    button.setText("");
                                } else {
                                    button.setText("F");
                                }
                            } else if (e.getButton() == MouseEvent.BUTTON1) {
                                button.setEnabled(false);
                                if (button.getName().equals("1")) {
                                    button.setBackground(Color.red);
                                    button.setOpaque(true);
                                    button.setText("X");

                                    for (int i = 0; i < size; i++) {
                                        for (int j = 0; j < size; j++) {
                                            field[i][j].setEnabled(false);
                                            if (field[i][j].getName().equals("1")) {
                                                field[i][j].setText("X");
                                            }
                                        }
                                    }

                                    restart(false);
                                } else {
                                    int x = button.getY() / buttonSize;
                                    int y = button.getX() / buttonSize;
                                    String minesCount = howManyMines(x, y);
                                    if (minesCount.equals("0")) {
                                        // bfs
                                        Queue<JButton> queue = new LinkedList<JButton>();
                                        queue.add(button);

                                        while (!queue.isEmpty()) {
                                            JButton curButton = queue.remove();
                                            x = curButton.getY() / buttonSize;
                                            y = curButton.getX() / buttonSize;
                                            curButton.setText(howManyMines(x, y));
                                            curButton.setEnabled(false);

                                            if (curButton.getText().equals("0")) {
                                                for (int i = -1; i < 2; i++) {
                                                    if (x + i > -1 && x + i < size) {
                                                        for (int j = -1; j < 2; j++) {
                                                            if (y + j > -1 && y + j < size) {
                                                                if (field[x + i][y + j].isEnabled()) {
                                                                    queue.add(field[x + i][y + j]);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    } else {
                                        button.setText(howManyMines(x, y));
                                    }
                                    check();
                                }
                            }
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                this.add(field[i][j]);
            }
        }

        Random random = new Random();
        int count = minesNumber;

        while (count > 0) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            if (field[x][y].getName().equals("1")) {
                count++;
            }
            field[x][y].setName("1");
            count--;
        }
    }

    private void check() {
        boolean win = true;

        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (field[i][j].isEnabled() && !field[i][j].getName().equals("1")) {
                    win = false;
                    break;
                }
            }
        }


        if (win) {
            restart(true);
        }
    }


    public static void main(String[] args) {
        new Minesweeper(10, 10);
    }
}

