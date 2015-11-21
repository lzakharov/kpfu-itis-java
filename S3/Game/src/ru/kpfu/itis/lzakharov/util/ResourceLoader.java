package ru.kpfu.itis.lzakharov.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by lzakharov on 07.11.15.
 */
public class ResourceLoader {
    private static final String PATH = "res/";

    public static BufferedImage loadImage(String filename) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(PATH + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}
