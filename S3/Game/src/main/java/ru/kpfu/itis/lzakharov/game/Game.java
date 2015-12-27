package ru.kpfu.itis.lzakharov.game;

import ru.kpfu.itis.lzakharov.IO.KeyInput;
import ru.kpfu.itis.lzakharov.game.entity.Player;
import ru.kpfu.itis.lzakharov.graphics.TextureAtlas;
import ru.kpfu.itis.lzakharov.net.Client;
import ru.kpfu.itis.lzakharov.net.Server;
import ru.kpfu.itis.lzakharov.net.packet.DisconnectPacket;
import ru.kpfu.itis.lzakharov.net.packet.LoginPacket;
import ru.kpfu.itis.lzakharov.util.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.BindException;
import java.net.SocketException;

/**
 * Created by lzakharov on 10.11.15.
 */

public class Game extends Canvas implements Runnable {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 664;
    private static final String NAME = "Tanks";
    private static final long SECOND = 1000000000l;
    private static final float UPDATE_RATE = 60.0f;
    private static final float UPDATE_INTERVAL = SECOND / UPDATE_RATE;
    private static final long IDLE_TIME = 1;
    private static final String ATLAS_FILENAME_FOR_SERVER = "texture_atlas_server.png";
    private static final String ATLAS_FILENAME_FOR_CLIENT = "texture_atlas_client.png";
    private static final String LOADING_ICON = "ajax-loader.gif";

    private TextureAtlas atlas;
    private TextureAtlas MPatlas;

    private JFrame frame;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private JPanel panel;
    private JLabel waitingLabel;

    private KeyInput input;

    private Client client;
    private Server server;

    private boolean running = false;
    private Thread gameThread;

    private $Map map;
    private Player player;

    public Game() {
        input = new KeyInput();

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        frame = new JFrame(NAME);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.addKeyListener(input);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (player != null) {
                    DisconnectPacket packet = new DisconnectPacket(player.getUsername());
                    if (server != null) {
                        server.sendDataToAllClients(packet.getData());
                    } else {
                        client.sendData(packet.getData());
                    }
                }
                System.exit(0);
            }
        });
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        panel = new JPanel();
        placeComponents(panel);
        frame.add(panel);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(290, 210, 80, 25);
        panel.add(usernameLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(380, 210, 160, 25);
        panel.add(usernameText);

        JLabel portLabel = new JLabel("PORT");
        portLabel.setBounds(290, 240, 80, 25);
        panel.add(portLabel);

        JTextField portText = new JTextField(8);
        portText.setBounds(380, 240, 160, 25);
        panel.add(portText);

        JLabel isServerLabel = new JLabel("Server?");
        isServerLabel.setBounds(290, 270, 100, 25);
        panel.add(isServerLabel);

        JCheckBox isServer = new JCheckBox();
        isServer.setBounds(380, 270, 25, 25);
        panel.add(isServer);

        JButton playButton = new JButton("PLAY!");
        playButton.setBounds(380, 320, 80, 25);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startWaiting(usernameText.getText(), Integer.parseInt(portText.getText()), isServer.isSelected());
            }
        });
        
        panel.add(playButton);
    }

    private void startWaiting(String username, int port, boolean isServer) {
        if (isServer) {
            try {
                server = new Server(this, port);
            } catch (SocketException e) {
                showMessage(e.getMessage());
            }
        }
        client = new Client(this, port, "localhost");

        if (server != null) {
            atlas = new TextureAtlas(ATLAS_FILENAME_FOR_SERVER);
            MPatlas = new TextureAtlas(ATLAS_FILENAME_FOR_CLIENT);
            player = new Player(this, username, atlas, 384, 64, input, client);
        } else {
            atlas = new TextureAtlas(ATLAS_FILENAME_FOR_CLIENT);
            MPatlas = new TextureAtlas(ATLAS_FILENAME_FOR_SERVER);
            player = new Player(this, username, atlas, 384, 472, input, client);
        }

        frame.remove(panel);
        waitingLabel = new JLabel("waiting for enemy...", ResourceLoader.loadImageIcon(LOADING_ICON), JLabel.CENTER);
        waitingLabel.setHorizontalTextPosition(JLabel.CENTER);
        waitingLabel.setVerticalTextPosition(JLabel.BOTTOM);
        frame.add(waitingLabel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        LoginPacket packet = new LoginPacket(player.getUsername(), player.getX(), player.getY());
        packet.writeData(client);

        Controller.getController().addEntity(player);
        map = new $Map(atlas);
        Controller.setMap(map);

        if (server == null) {
            this.start();
        }
    }

    public TextureAtlas getMPatlas() {
        return MPatlas;
    }

    public void showMessage(String message) {
        frame.remove(this);
        int result = JOptionPane.showConfirmDialog(frame, message, "Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    public synchronized void start() {
        if (running) {
            return;
        } else {
            frame.remove(waitingLabel);
            frame.add(this, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
            frame.requestFocus();
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

    private synchronized void update() {
        Controller.getController().update();
    }

    private synchronized void render() {
        BufferStrategy strategy = this.getBufferStrategy();
        if (strategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics2D graphics = (Graphics2D) strategy.getDrawGraphics();

        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        map.render(graphics);
        Controller.getController().render(graphics);

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

