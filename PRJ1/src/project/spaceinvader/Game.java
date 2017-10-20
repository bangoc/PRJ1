package project.spaceinvader;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;

public class Game extends Canvas implements ActionListener {
        private BufferStrategy strategy;
        public JFrame display;
        public JButton buttonPlay, buttonQuit;
        private Entity ufo, ship;
        private static HighScore highScore;
        private ArrayList<Entity> entities = new ArrayList<Entity>();
        private ArrayList<Entity> removeList = new ArrayList<Entity>();
        private String actionPlay = "play";
        private String actionQuit = "quit";
        private final static double speed = 300.0;
        private static int row = 3;
        private int UFOCount;
        private long lastFire = 0;
        private long firingInterval = 400;
        public double score; 
        private final static int IN_GAME = 0;
        private final static int MAIN_MENU = 1;
        private final static int GAME_OVER = 2;
        private int gameState = MAIN_MENU;
        private boolean waitingForKeyPress = true;
        private boolean leftPressed = false;
        private boolean rightPressed = false;
        private boolean firePressed = false;
        private boolean logicRequiredThisLoop = false;
        public boolean gameRunning = false;
        private ImageIcon icon = null;
        private Image imageBackgroundStart, imageButtonPlay, imageButtonQuit, imageStars;
        private MusicStart music = new MusicStart();
        public MusicFire fire = new MusicFire();

        public Game() {
                display = new JFrame(
                                "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-GAME SPACE INAVDER-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                JPanel panel = (JPanel) display.getContentPane();
                panel.setPreferredSize(new Dimension(790, 590));
                panel.add(createButton1(actionPlay, "play"));
                panel.add(createButton2(actionQuit, "quit"));
                panel.setLayout(null);
                setBounds(0, 0, 800, 600);
                panel.add(this);
                setIgnoreRepaint(true);
                display.pack();
                display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                display.setLocationRelativeTo(null);
                display.setResizable(false);
                display.setVisible(true);
                addKeyListener(new KeyInputHandler());
                requestFocus();
                createBufferStrategy(2);
                strategy = getBufferStrategy();
                initEntities(row);
        }

        private void initEntities(int rowT) {
                ship = new ShipEntity(this, "sprites/ship.jpg", 370, 550);
                entities.add(ship);
                UFOCount = 0;
                for (rowT = 0; rowT < row; rowT++) {
                        for (int x = 0; x < 12; x++) {
                                ufo = new UFOEntity(this, "sprites/ufo.png", 100 + (x * 50),
                                                (50) + rowT * 30);
                                entities.add(ufo);
                                UFOCount++;
                        }
                }
        }

        public void updateLogic() {
                logicRequiredThisLoop = true;
        }

        public void removeEntity(Entity entity) {
                removeList.add(entity);
        }

        public void notifyUFOKilled() {
                UFOCount--;
                tryToBoom();
                if (UFOCount == 0) {
                        entities.clear();
                        initEntities(row = row + 1);
                }
                for (int i = 0; i < entities.size(); i++) {
                        Entity entity = (Entity) entities.get(i);
                        if (entity instanceof UFOEntity) {
                                entity.setHorizontalMovement(entity.getHorizontalMovement() * 1.02);
                        }
                }
        }

        public void tryToFire() {
                if (System.currentTimeMillis() - lastFire < firingInterval) {
                        return;
                }
                lastFire = System.currentTimeMillis();
                ShotEntity shot = new ShotEntity(this, "sprites/rocket.png", ship.getX() + 10,
                                ship.getY() - 30);
                entities.add(shot);
        }

        public void tryToBoom() {
                Entity boom = new BoomEntity(this, "sprites/boom.gif", ufo.getX() - 300,
                                ufo.getY());
                entities.add(boom);
        }

        public void mainMenu() {
                Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
                URL url = getClass().getResource("/sprites/backgroundStart.jpg");
                imageBackgroundStart = Toolkit.getDefaultToolkit().getImage(url);
                g.drawImage(imageBackgroundStart, 0, 0, 800, 600, this);
                g.dispose();
                strategy.show();
        }

        private void startGame() {
        		music.start();
                entities.clear();
                initEntities(row);
                score = 0;
                buttonPlay.setVisible(false);
                buttonQuit.setVisible(false);
                leftPressed = false;
                rightPressed = false;
                firePressed = false;
                gameState = IN_GAME;
                gameRunning = true;
                waitingForKeyPress = false;
                this.setFocusable(true);
        }

        public void gameLoop() {
                long lastLoopTime = System.currentTimeMillis();
                while (gameRunning) {
                        long delta = System.currentTimeMillis() - lastLoopTime;
                        lastLoopTime = System.currentTimeMillis();
                        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
                        URL url = getClass().getResource("/sprites/stars.gif");
                        imageStars = Toolkit.getDefaultToolkit().getImage(url);
                        g.drawImage(imageStars, 0, 0, 800, 600, this);
                        g.setColor(Color.RED);
                        g.setFont(new Font("Arial", Font.BOLD, 20));
                        g.drawString("SCORE: " + Math.round(score), 350, 20);
                        g.drawString("HIGH SCORE: " + Math.round(highScore.Read()), 20, 20);
                        if (!waitingForKeyPress) {
                                for (int i = 0; i < entities.size(); i++) {
                                        Entity entity = (Entity) entities.get(i);
                                        entity.move(delta);
                                }
                        }
                        for (int i = 0; i < entities.size(); i++) {
                                Entity entity = (Entity) entities.get(i);
                                entity.draw(g);
                        }
                        for (int p = 0; p < entities.size(); p++) {
                                for (int s = p + 1; s < entities.size(); s++) {
                                        Entity me = (Entity) entities.get(p);
                                        Entity him = (Entity) entities.get(s);
                                        if (me.collidesWith(him)) {
                                                me.collidedWith(him);
                                                him.collidedWith(me);
                                        }
                                }
                        }
                        entities.removeAll(removeList);
                        removeList.clear();
                        if (logicRequiredThisLoop) {
                                for (int i = 0; i < entities.size(); i++) {
                                        Entity entity = (Entity) entities.get(i);
                                        entity.doLogic();
                                }
                                logicRequiredThisLoop = false;
                        }
                        g.dispose();
                        strategy.show();
                        ship.setHorizontalMovement(0);
                        if ((leftPressed) && (!rightPressed)) {
                                ship.setHorizontalMovement(-speed);
                        } else if ((rightPressed) && (!leftPressed)) {
                                ship.setHorizontalMovement(speed);
                        }
                        if (firePressed) {
                                tryToFire();
                                // fire.start();
                        }
                        try {
                                Thread.sleep(5);
                        } catch (Exception e) {
                        }
                }
                gameState = GAME_OVER;
        }

        public void gameOver() {
        		music.stop();
                Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 800, 600);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("GAME OVER", 250, 150);
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("SCORE:           " + Math.round(score), 310, 300);
                g.drawString("HIGH SCORE: " + Math.round(highScore.Read()), 310, 340);
                g.dispose();
                strategy.show();
        }

        private JButton createButton1(String action1, String buttonName1) {
                URL url = getClass().getResource("/sprites/buttonPlay.png");
                imageButtonPlay = Toolkit.getDefaultToolkit().getImage(url);
                icon = new ImageIcon(imageButtonPlay);
                buttonPlay = new JButton(buttonName1, icon);
                buttonPlay.setBounds(300, 300, 190, 48);
                buttonPlay.setActionCommand(action1);
                buttonPlay.addActionListener(this);
                return buttonPlay;
        }

        private JButton createButton2(String action2, String buttonName2) {
                URL url = getClass().getResource("/sprites/buttonQuit.png");
                imageButtonQuit = Toolkit.getDefaultToolkit().getImage(url);
                icon = new ImageIcon(imageButtonQuit);
                buttonQuit = new JButton(buttonName2, icon);
                buttonQuit.setBounds(300, 400, 190, 48);
                buttonQuit.setActionCommand(action2);
                buttonQuit.addActionListener(this);
                return buttonQuit;
        }

        public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (actionPlay.equals(command)) {
                        startGame();
                }
                if (actionQuit.equals(command)) {
                        System.exit(0);
                }
        }

        private class KeyInputHandler extends KeyAdapter {
                public void keyPressed(KeyEvent e) {
                        if (waitingForKeyPress) {
                                return;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                                leftPressed = true;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                                rightPressed = true;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                                firePressed = true;
                        }
                }

                public void keyReleased(KeyEvent e) {
                        if (waitingForKeyPress) {
                                return;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                                leftPressed = false;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                                rightPressed = false;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                                firePressed = false;
                        }
                }
        }

        public void mainGameLoop() {
                while (true) {
                        switch (gameState) {
                        case MAIN_MENU:
                                mainMenu();
                                break;
                        case IN_GAME:
                                gameLoop();
                                break;
                        case GAME_OVER:
                                gameOver();
                                break;
                        default:
                                break;
                        }
                }
        }

        public static void main(String argv[]) {
                Game game = new Game();
                game.mainGameLoop();
        }
}
