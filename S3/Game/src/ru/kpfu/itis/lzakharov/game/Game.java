package ru.kpfu.itis.lzakharov.game;

import ru.kpfu.itis.lzakharov.IO.KeyInput;
import ru.kpfu.itis.lzakharov.game.entitie.Player;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;
import ru.kpfu.itis.lzakharov.net.Client;
import ru.kpfu.itis.lzakharov.net.Server;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by lzakharov on 10.11.15.
 */

public class Game extends Canvas implements Runnable {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String NAME = "Tanks";
    private static final long SECOND = 1000000000l;
    private static final float UPDATE_RATE = 60.0f;
    private static final float UPDATE_INTERVAL = SECOND / UPDATE_RATE;
    private static final long IDLE_TIME = 1;
    private static final String ATLAS_FILENAME = "texture_atlas.png";

    public TextureAtlas atlas;

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private KeyInput input;

    Controller controller;

    private Client client;
    private Server server;

    private boolean running = false;
    private Thread gameThread;

    private Player player;

    public Game() {
        atlas = new TextureAtlas(ATLAS_FILENAME);

        controller = new Controller();
        input = new KeyInput();


        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        JFrame frame = new JFrame(NAME);
        frame.addKeyListener(input);
        player = new Player(JOptionPane.showInputDialog(frame, "Please enter a username"), 100, 100, input);
        client = new Client(controller, "localhost");
        if (JOptionPane.showConfirmDialog(frame, "Do you want to run the server", "", 0, JOptionPane.YES_NO_OPTION) == 0) {
            server = new Server();
        }
        controller.addEntity(player);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        this.start();
    }

    public synchronized void start() {
        if (running) {
            return;
        } else {
            running = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public synchronized void stop() {
        if (!running) {
            return;
        } else {
            running = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void update() {
        controller.update();
    }

    private void render() {
        BufferStrategy strategy = this.getBufferStrategy();
        if (strategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics2D graphics = (Graphics2D) strategy.getDrawGraphics();

        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        controller.render(graphics);

        graphics.dispose();
        strategy.show();
    }

    @Override
    public void run() {
        long last_time = System.nanoTime();
        float delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - last_time) / UPDATE_INTERVAL;
            last_time = now;
            boolean render = false;

            while (delta > 1) {
                update();
                delta--;
                render = true;
            }

            if (render) {
                render();
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        stop();
    }
}

