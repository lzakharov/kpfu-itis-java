package ru.kpfu.itis.lzakharov.game.entity;

import ru.kpfu.itis.lzakharov.IO.KeyInput;
import ru.kpfu.itis.lzakharov.game.Controller;
import ru.kpfu.itis.lzakharov.game.Game;
import ru.kpfu.itis.lzakharov.graphics.SpriteSheet;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;
import ru.kpfu.itis.lzakharov.net.Client;
import ru.kpfu.itis.lzakharov.net.packet.MovePacket;
import ru.kpfu.itis.lzakharov.net.packet.ShootPacket;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Player extends Entity {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public static final int	SPRITE_SCALE = 32;
    public static final int	SPRITES_PER_HEADING	= 8;

    public int getHealth() {
        return health;
    }


    private enum Direction {
        NORTH(0 * SPRITE_SCALE, 0 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE, 0),
        EAST(0 * SPRITE_SCALE, 3 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE, 1),
        SOUTH(0 * SPRITE_SCALE, 1 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE, 2),
        WEST(0 * SPRITE_SCALE, 2 * SPRITE_SCALE, SPRITES_PER_HEADING * SPRITE_SCALE, 1 * SPRITE_SCALE, 3);

        private int	x, y, w, h, d;

        Direction(int x, int y, int w, int h, int d) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.d = d;
        }

        public int getD() {
            return d;
        }

        protected BufferedImage texture(TextureAtlas atlas) {
            return atlas.cut(x, y, w, h);
        }
    }

    private Game game;
    private TextureAtlas atlas;
    private Map<Direction, SpriteSheet> spriteSheetMap;
    private KeyInput input;
    private Client client;
    private String username;
    private Direction direction;
    private float speed = 5.0f;
    private float scale = 1.0f;
    private int index = 0;
    private int health = 5;
    private int bulletSpeed = 8;
    private long lastShootTime = 0;
    private long shootingPause = 500;

    public Player(Game game, String username, TextureAtlas atlas, int x, int y, KeyInput input, Client client) {
        super(EntityType.PLAYER, x, y);
        this.game = game;
        this.username = username;
        this.atlas = atlas;
        this.input = input;
        this.direction = Direction.NORTH;
        this.client = client;

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




    public void incIndex() {
        index++;
        if (index >= SPRITES_PER_HEADING) {
            index = index % SPRITES_PER_HEADING;
        }
    }

    public void damage() {
        if (health > 0) {
            this.health--;
        }
        if (health == 0) {
            // FIXME
            Controller.removeEntity(this);
            game.showMessage("Player " + username + " lost!");
        }
    }

    public String getUsername() {
        return username;
    }

    public boolean hasCollision(int x, int y) {
        if (x + (SPRITE_SCALE / 2) > getX() && (x + (SPRITE_SCALE / 2) < getX() + SPRITE_SCALE) && y + (SPRITE_SCALE / 2) > getY() && y + (SPRITE_SCALE / 2) < getY() + SPRITE_SCALE) {
            return true;
        }

        return false;
    }

    @Override
    public void update() {
        if (input != null) {
            int newX = x;
            int newY = y;

            if (input.getKey(KeyEvent.VK_UP)) {
                direction = Direction.NORTH;
                newY -= speed;
                incIndex();
            } else if (input.getKey(KeyEvent.VK_RIGHT)) {
                direction = Direction.EAST;
                newX += speed;
                incIndex();
            } else if (input.getKey(KeyEvent.VK_DOWN)) {
                direction = Direction.SOUTH;
                newY += speed;
                incIndex();
            } else if (input.getKey(KeyEvent.VK_LEFT)) {
                direction = Direction.WEST;
                newX -= speed;
                incIndex();
            } else if (input.getKey(KeyEvent.VK_SPACE)) {
                long now = System.currentTimeMillis();
                if (now - lastShootTime > shootingPause) {
                    ShootPacket packet = new ShootPacket(username, x, y, direction.getD(), bulletSpeed);
                    packet.writeData(client);
                    lastShootTime = now;
                }
            }

            if ((x != newX || y != newY)
                    && (newX >= (-1) * speed && newX <= WIDTH - SPRITE_SCALE)
                    && (newY >= (-1) * speed && newY <= HEIGHT - SPRITE_SCALE)
                    && Controller.getMap().isEmpty(newX, newY)) {
                x = newX;
                y = newY;
                MovePacket packet = new MovePacket(username, x, y, direction.getD());
                packet.writeData(client);
            }
        }
    }

    @Override
    public void render(Graphics2D graphics) {
        SpriteSheet sheet = spriteSheetMap.get(direction);
        sheet.getSprite(index, scale).render(graphics, x, y);
    }
}

