package ru.kpfu.itis.lzakharov.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by lzakharov on 07.11.15.
 */
public class Sprite {
    private BufferedImage image;
    private float scale;

    public Sprite(BufferedImage image, float scale) {
        this.image = image;
        this.scale = scale;
    }

    public void render(Graphics2D graphics, int x, int y) {
        graphics.drawImage(image, x, y, (int) (image.getWidth() * scale), (int) (image.getHeight() * scale), null);
    }
}
