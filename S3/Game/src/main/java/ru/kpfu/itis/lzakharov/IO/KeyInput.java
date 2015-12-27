package ru.kpfu.itis.lzakharov.IO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by lzakharov on 06.11.15.
 */

public class KeyInput implements KeyListener {
    private boolean[] keys = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public boolean getKey(int keyCode) {
        return keys[keyCode];
    }
}
