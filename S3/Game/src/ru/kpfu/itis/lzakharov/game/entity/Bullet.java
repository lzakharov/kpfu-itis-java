package ru.kpfu.itis.lzakharov.game.entitie;

import java.awt.*;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Bullet extends Entity {
    private String owner;
    private int direction;
    private int speed;

    public Bullet(String username, int x, int y, int direction, int speed) {
        super(EntityType.BULLET, x, y);
        this.owner = username;
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D graphics) {

    }
}

