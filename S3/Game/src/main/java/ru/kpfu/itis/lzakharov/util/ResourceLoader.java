package ru.kpfu.itis.lzakharov.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by lzakharov on 07.11.15.
 */
public class ResourceLoader {

    public static BufferedImage loadImage(String filename) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public static ImageIcon loadImageIcon(String filename) {
        ImageIcon imageIcon = null;

        imageIcon = new ImageIcon(ResourceLoader.class.getClassLoader().getResource(filename));

        return imageIcon;
    }

    public static int[][] loadMap(String filename, int width, int height) {
        int[][] map = new int[height][width];

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.class.getClassLoader().getResourceAsStream(filename)));

            for (int i = 0; i < height; i++) {
                String[] line = reader.readLine().split(" ");
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
