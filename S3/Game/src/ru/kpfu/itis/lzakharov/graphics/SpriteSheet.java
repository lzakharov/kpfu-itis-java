package ru.kpfu.itis.lzakharov.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by lzakharov on 07.11.15.
 */
public class SpriteSheet {
    private BufferedImage sheet;
    private int spriteCount;
    private int size;
    private int spritesInWidth;

    public SpriteSheet(BufferedImage sheet, int spriteCount, int size) {
        this.sheet = sheet;
        this.spriteCount = spriteCount;
        this.size = size;
        this.spritesInWidth = sheet.getWidth() / size;
    }

    public Sprite getSprite(int index, float scale) {

        index = index % spriteCount;

        int x = index % spritesInWidth * size;
        int y = index / spritesInWidth * size;

        return new Sprite(sheet.getSubimage(x, y, size, size), scale);

    }
}
