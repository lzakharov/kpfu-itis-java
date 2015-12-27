package ru.kpfu.itis.lzakharov.game.entity;

import ru.kpfu.itis.lzakharov.game.Controller;
import ru.kpfu.itis.lzakharov.graphics.Sprite;
import ru.kpfu.itis.lzakharov.graphics.SpriteSheet;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;

import java.awt.*;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Bullet extends Entity {
    private static final int SPRITE_SCALE = 32;
    private static final String ATLAS_FILENAME = "texture_atlas.png";
    private TextureAtlas atlas = new TextureAtlas(ATLAS_FILENAME);
    private String owner;
    private int direction;
    private int speed;
    private Sprite sprite;

    public Bullet(String username, int x, int y, int direction, int speed) {
        super(EntityType.BULLET, x, y);
        switch (direction) {
            case 0:
                this.y -= 12;
                break;
            case 1:
                this.x += 12;
                break;
            case 2:
                this.y += 12;
                break;
            case 3:
                this.x -= 12;
                break;
        }
        this.owner = username;
        this.direction = direction;
        this.speed = speed;

        SpriteSheet sheet = new SpriteSheet(atlas.cut(4 * SPRITE_SCALE, 8 * SPRITE_SCALE, SPRITE_SCALE, SPRITE_SCALE), 1, SPRITE_SCALE);
        sprite = sheet.getSprite(0, 1);
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public synchronized void update() {
        switch (direction) {
            // NORTH
            case 0:
                y -= speed;
                break;
            // EAST
            case 1:
                x += speed;
                break;
            // SOUTH
            case 2:
                y += speed;
                break;
            // WEST
            case 3:
                x -= speed;
                break;
        }

        if (x < 0 || x > 800 || y < 0 || y > 600 || Controller.getMap().destroyBlock(x, y) || Controller.tryToDestroyEnemy(this)) {
            Controller.removeEntity(this);
        }
    }

    @Override
    public synchronized void render(Graphics2D graphics) {
        sprite.render(graphics, x, y);
    }
}

