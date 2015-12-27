package ru.kpfu.itis.lzakharov.game.entity;

import java.awt.*;

/**
 * Created by lzakharov on 15.11.15.
 */

public abstract class Entity {
    protected EntityType entityType;
    protected int x, y;

    public Entity(EntityType entityType, int x, int y) {
        this.entityType = entityType;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public synchronized void update() {

    }

    public synchronized void render(Graphics2D graphics) {

    }
}

