package ru.kpfu.itis.lzakharov.game.entitie;

import ru.kpfu.itis.lzakharov.IO.KeyInput;
import ru.kpfu.itis.lzakharov.graphics.SpriteSheet;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Player extends Entity {
    public static final int	SPRITE_SCALE = 32;
    public static final int	SPRITES_PER_HEADING	= 8;

    private enum Direction {
        NORTH(0 * SPRITE_SCALE, 0 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH(0 * SPRITE_SCALE, 1 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST(0 * SPRITE_SCALE, 2 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST(0 * SPRITE_SCALE, 3 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE);

        private int	x, y, w, h;

        Direction(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        protected BufferedImage texture(TextureAtlas atlas) {
            return atlas.cut(x, y, w, h);
        }
    }

    private TextureAtlas atlas = new TextureAtlas("texture_atlas.png");
    private Map<Direction, SpriteSheet> spriteSheetMap;
    private KeyInput input;
    private String username;
    private Direction direction;
    private float speed = 5.0f;
    private float scale = 1.0f;
    private int index = 0;
    private int bulletSpeed = 5;
    private long lastShootTime = 0;

    public Player(int x, int y) {
        super(EntityType.PLAYER, x, y);
    }

    public Player(String username, int x, int y, KeyInput input) {
        super(EntityType.PLAYER, x, y);
        this.username = username;
        this.input = input;
        this.direction = Direction.NORTH;

        spriteSheetMap = new HashMap<>();

        for (Direction direction : Direction.values()) {
            SpriteSheet sheet = new SpriteSheet(direction.texture(atlas), SPRITES_PER_HEADING, 32);
            spriteSheetMap.put(direction, sheet);
        }
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDirection(int direction) {
        switch (direction) {
            case 0:
                this.direction = Direction.NORTH;
                break;
            case 1:
                this.direction = Direction.EAST;
                break;
            case 2:
                this.direction = Direction.SOUTH;
                break;
            case 3:
                this.direction = Direction.WEST;
                break;
        }
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void update() {
        if (input != null) {
            int newX = x;
            int newY = y;

            if (input.getKey(KeyEvent.VK_UP)) {
                newY -= speed;
                index++;
                direction = Direction.NORTH;
            } else if (input.getKey(KeyEvent.VK_RIGHT)) {
                newX += speed;
                index++;
                direction = Direction.EAST;
            } else if (input.getKey(KeyEvent.VK_DOWN)) {
                newY += speed;
                index++;
                direction = Direction.SOUTH;
            } else if (input.getKey(KeyEvent.VK_LEFT)) {
                newX -= speed;
                index++;
                direction = Direction.WEST;
            } else if (input.getKey(KeyEvent.VK_SPACE)) {
                // TODO: Shoot!
            }

            x = newX;
            y = newY;
        }
    }

    @Override
    public void render(Graphics2D graphics) {
        SpriteSheet sheet = spriteSheetMap.get(direction);
        sheet.getSprite(index, scale).render(graphics, x, y);
    }
}

