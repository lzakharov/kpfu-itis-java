package ru.kpfu.itis.lzakharov.game;

import ru.kpfu.itis.lzakharov.game.entitie.Bullet;
import ru.kpfu.itis.lzakharov.game.entitie.Entity;
import ru.kpfu.itis.lzakharov.game.entitie.Player;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Controller {
    private static final long SHOOTING_INTERVAL = 500;

    private LinkedList<Entity> entities;

    public Controller() {
        entities = new LinkedList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public void render(Graphics2D graphics) {
        for (Entity entity : entities) {
            entity.render(graphics);
        }
    }

    private Player getPlayer(String username) {
        for (Entity entity : entities) {
            if (entity instanceof Player && ((Player) entity).getUsername().equals(username)) {
                return (Player) entity;
            }
        }

        return null;
    }

    public void removePlayer(String username) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Player && ((Player) entities.get(i)).getUsername().equals(username)) {
                entities.remove(i);
                break;
            }
        }
    }

    public void movePlayer(String username, int x, int y, int direction) {
        if (getPlayer(username) != null) {
            Player player = getPlayer(username);
            player.setCoordinates(x, y);
            player.setDirection(direction);
        }
    }

    public void shoot(Bullet bullet) {
        // TODO: realize shooting method
    }
}

