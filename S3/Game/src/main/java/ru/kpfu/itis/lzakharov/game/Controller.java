package ru.kpfu.itis.lzakharov.game;

import ru.kpfu.itis.lzakharov.game.entity.Bullet;
import ru.kpfu.itis.lzakharov.game.entity.Entity;
import ru.kpfu.itis.lzakharov.game.entity.Player;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by lzakharov on 15.11.15.
 */

public class Controller {
    private static final long SHOOTING_INTERVAL = 500;

    private volatile static Controller controller;

    private volatile static LinkedList<Entity> entities;
    private volatile static LinkedList<Entity> entitiesToAdd;
    private volatile static LinkedList<Entity> entitiesToRemove;

    private static $Map map;

    private Controller() {
        entities = new LinkedList<>();
        entitiesToAdd = new LinkedList<>();
        entitiesToRemove = new LinkedList<>();
    }

    public static $Map getMap() {
        return map;
    }

    public static void setMap($Map map) {
        Controller.map = map;
    }

    public synchronized static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }

        return controller;
    }

    public synchronized static void addEntity(Entity entity) {
        entitiesToAdd.add(entity);
    }

    public synchronized static void removeEntity(Entity entity) {
        entitiesToRemove.add(entity);
    }

    public static synchronized void update() {
        long time = System.currentTimeMillis();
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            entity.update();
        }

        for (Entity entity: entitiesToRemove) {
            entities.remove(entity);
        }

        for (Entity entity: entitiesToAdd) {
            entities.add(entity);
        }

        entitiesToAdd.clear();
    }

    public synchronized static void render(Graphics2D graphics) {
        int i = 0;
        for (Entity entity : entities) {
            entity.render(graphics);
            if (entity instanceof Player) {
                int health = ((Player)entity).getHealth();
                graphics.setColor(Color.RED);
                graphics.fillRect(32 + (352 * i), 588, 64 * health, 24);
                graphics.setColor(Color.WHITE);
                graphics.drawRect(32 + (352 * i), 588, 64 * 5, 24);
                graphics.drawString(((Player)entity).getUsername(), 128 + (352 * i), 604);

                i++;
            }
        }

    }

    public synchronized static Player getPlayer(String username) {
        for (Entity entity : entities) {
            if (entity instanceof Player && ((Player) entity).getUsername().equals(username)) {
                return (Player) entity;
            }
        }

        return null;
    }

    public synchronized static void removePlayer(String username) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Player && ((Player) entities.get(i)).getUsername().equals(username)) {
                entities.remove(i);
                break;
            }
        }
    }

    public synchronized static void movePlayer(String username, int x, int y, int direction) {
        if (getPlayer(username) != null) {
            Player player = getPlayer(username);
            player.setCoordinates(x, y);
            player.setDirection(direction);
            player.incIndex();
        }
    }

    public synchronized static void shoot(Bullet bullet) {
        addEntity(bullet);
    }

    public synchronized static boolean tryToDestroyEnemy(Bullet bullet) {
        for (Entity entity: entities) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                if (!player.getUsername().equals(bullet.getOwner()) && player.hasCollision(bullet.getX(), bullet.getY())) {
                    player.damage();
                    return true;
                }
            } else {
                Bullet bullet1 = (Bullet) entity;
                if (!bullet1.getOwner().equals(bullet.getOwner()) && (bullet1.getX() == bullet.getX() && bullet1.getY() == bullet.getY())) {
                    removeEntity(entity);
                    return true;
                }
            }
        }
        return false;
    }
}

