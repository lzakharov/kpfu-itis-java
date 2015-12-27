package ru.kpfu.itis.lzakharov.game;

import ru.kpfu.itis.lzakharov.game.entity.EntityType;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;
import ru.kpfu.itis.lzakharov.util.ResourceLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzakharov on 14.12.15.
 */

public class $Map {
    public static final int TEXTURE_SCALE = 32;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int TEXTURES_IN_WIDTH = WIDTH / TEXTURE_SCALE;
    private static final int TEXTURES_IN_HEIGHT = HEIGHT / TEXTURE_SCALE;
    private static final String FILENAME = "map.txt";

    private TextureAtlas atlas;
    private Map<EntityType, BufferedImage> texturesMap;

    private int[][] map;

    public $Map(TextureAtlas atlas) {
        this.atlas = atlas;

        this.map = ResourceLoader.loadMap(FILENAME, TEXTURES_IN_WIDTH, TEXTURES_IN_HEIGHT);

        this.texturesMap = new HashMap<>();
        texturesMap.put(EntityType.FLOOR,
                atlas.cut(0 * TEXTURE_SCALE, 4 * TEXTURE_SCALE, 1 * TEXTURE_SCALE, 1 * TEXTURE_SCALE));
        texturesMap.put(EntityType.INDESTRUCTIBLE_BLOCK,
                atlas.cut(5 * TEXTURE_SCALE, 4 * TEXTURE_SCALE, 1 * TEXTURE_SCALE, 1 * TEXTURE_SCALE));
        texturesMap.put(EntityType.SAMPLE_BLOCK,
                atlas.cut(6 * TEXTURE_SCALE, 4 * TEXTURE_SCALE, 1 * TEXTURE_SCALE, 1 * TEXTURE_SCALE));
    }

    public boolean isEmpty(int y, int x) {
        return (map[(x / TEXTURE_SCALE)][(y / TEXTURE_SCALE)] == 0)
                && (map[(x / TEXTURE_SCALE)][(y / TEXTURE_SCALE) + 1] == 0)
                && (map[(x / TEXTURE_SCALE) + 1][(y / TEXTURE_SCALE)] == 0)
                && (map[(x / TEXTURE_SCALE) + 1][(y / TEXTURE_SCALE) + 1] == 0);
    }

    public boolean destroyBlock(int y, int x) {
        int x1 = (x + (TEXTURE_SCALE / 2)) / TEXTURE_SCALE;
        int y1 = (y + (TEXTURE_SCALE / 2)) / TEXTURE_SCALE;
        if (map[x1][y1] == 0) {
            return false;
        }

        if (map[x1][y1] == 5) {
            map[x1][y1] = 0;
        }

        return true;
    }

    public void render(Graphics2D graphics) {
        for (int x = 0; x < TEXTURES_IN_HEIGHT; x++) {
            for (int y = 0; y < TEXTURES_IN_WIDTH; y++) {
                graphics.drawImage(texturesMap.get(getEntityType(map[x][y])), y * TEXTURE_SCALE, x * TEXTURE_SCALE, TEXTURE_SCALE, TEXTURE_SCALE, null);
            }
        }
    }

    private EntityType getEntityType(int type) {
        switch (type) {
            case 4:
                return EntityType.INDESTRUCTIBLE_BLOCK;
            case 5:
                return EntityType.SAMPLE_BLOCK;
            default:
                return EntityType.FLOOR;
        }

    }
}

