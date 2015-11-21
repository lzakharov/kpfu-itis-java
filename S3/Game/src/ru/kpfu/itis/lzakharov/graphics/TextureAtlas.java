package ru.kpfu.itis.lzakharov.graphics;

import ru.kpfu.itis.lzakharov.util.ResourceLoader;

import java.awt.image.BufferedImage;

/**
 * Created by lzakharov on 07.11.15.
 */
public class TextureAtlas {
    public BufferedImage image;

    public TextureAtlas(String imageName) {
        image = ResourceLoader.loadImage(imageName);
    }

    public BufferedImage cut(int x, int y, int width, int height) {
        return image.getSubimage(x, y, width, height);
    }
}
