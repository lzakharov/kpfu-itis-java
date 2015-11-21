package ru.kpfu.itis.lzakharov.game.entitie;

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

    public void update() {

    }

    public void render(Graphics2D graphics) {

    }
}

