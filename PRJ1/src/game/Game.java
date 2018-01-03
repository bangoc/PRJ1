package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageFilter;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.BoomEntity;
import entity.Entity;
import entity.ShipEntity;
import entity.ShotEntity;
import entity.UFOEntity;
import music.*;
public class Game extends Canvas implements ActionListener {
	public int score;// score of player
	private int UFOCount;// number of UFO on screen
	public JFrame display;
	private ImageIcon icon;
	public Entity ufo, ship, shipNew1, shipNew2, shipNew3; // object ufo and ship
	private BufferStrategy strategy;// the stragey that allows us to use accelerate page flipping
	private static HighScore highScore;// highscore of player
	public JButton buttonPlay, buttonQuit, buttonHighScore, buttonMenu, buttonExit;// button
	public JButton buttonResume, buttonMusic, buttonMainMenu, buttonExit2;
	// The list of all the entities that exist in game
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	// The list of entities that need to be removed from the game this loop
	private ArrayList<Entity> removeList = new ArrayList<Entity>();
	private String actionPlay = "play";
	private String actionHighScore = "high-score";
	private String actionQuit = "quit";
	private String actionMenu = "menu";
	private String actionReturnMenu = "mainMenu";
	private String actionExit = "exit";
	private String actionresume = "resume";
	private String actionExit2 = "exit2";
	private String actionMusic = "music";
	private String check = null;
	private String valueLoop;
	public int numberTurn = 3;
	private long lastFire = 0;
	public long delta2 = 0;// the time at which last fired a shot
	private static int row = 3;// the rows of ufo on screen
	private long firingInterval = 700;// the interval between fired shot (ms)
	private final static double speed = 300.0; // speed of ship (pixels/sec)
	private final static int IN_GAME = 0; // const to start game looping
	private final static int MAIN_MENU = 1;// const to open main menu
	private final static int GAME_OVER = 2; // const to end game
	private final static int HIGH_SCORE = 3;// const to view high score
	private int gameState = MAIN_MENU;
	public boolean gameRunning = false;// if false the game loop is not running
	public boolean firePressed = false;// ship are firing if true
	public boolean leftPressed = false;// left key is currently pressed if true
	public boolean rightPressed = false;// right key is currently pressed if true
	private boolean waitingForKey = true;// if true, game start
	private boolean logicRequiredThisLoop = false;// result of a game event
	private boolean checkOver = true;
	public Thread thread = null;
	private Image imageBackgroundStart, imageButtonPlay, imageButtonMenu, imageButtonQuit, imageStars, imageResume,
			imageMusic;// image of game
	boolean flag = true;
	int returnMain = 1;
	int flagMusic = 1;
	//
	public MusicStart music_start = new MusicStart();
	public MusicShoot musicShoot = new MusicShoot();
	// private MusicBoom musicBoom = new MusicBoom();

	// construct game
	public Game() {
		// create a JFrame to contain game
		display = new JFrame(
				"-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-GAME SPACE INAVDER-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		// create JPanel
		JPanel panel = (JPanel) display.getContentPane();
		panel.setPreferredSize(new Dimension(790, 595));
		panel.add(createButtonPlay(actionPlay, "play"));
		panel.add(createButtonHighScore(actionHighScore, "high-score"));
		panel.add(createButtonQuit(actionQuit, "quit"));
		panel.add(createButtonMenu(actionMenu, "menu"));
		panel.add(createButtonExit(actionExit, "exit"));
		panel.add(createButtonResume(actionresume, "resume"));
		panel.add(createButtonReturnMenu(actionReturnMenu, "returnMainMenu"));
		panel.add(createButtonExit2(actionExit2, "exit2"));
		panel.add(createButtonMusic(actionMusic, "music"));
		buttonMusic.setVisible(false);

		buttonMainMenu.setVisible(false);
		buttonPlay.setVisible(false);
		buttonQuit.setVisible(false);
		buttonHighScore.setVisible(false);
		buttonMenu.setVisible(false);
		buttonExit.setVisible(false);
		buttonExit2.setVisible(false);
		buttonResume.setVisible(false);
		panel.setLayout(null);
		// setup canvas size and put it into the content of the frame
		setBounds(0, 0, 800, 600);
		panel.add(this);
		// not repaint canvas
		setIgnoreRepaint(true);
		// make the window visible
		display.pack();
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setLocationRelativeTo(null);
		display.setResizable(false);
		display.setVisible(true);
		// add a key input system to canvas
		addKeyListener(new KeyInputHandler());
		//
		requestFocus();
		// create the buffering strategy which will allow AWT to manage our accelerated
		// graphics
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}

	// Initialise the starting state of the entities (ship and ufo)
	public void initUFO(int row) {
		UFOCount = 0;
		for (int rowT = 0; rowT < row; rowT++) {
			for (int x = 0; x < 12; x++) {
				ufo = new UFOEntity(this, "sprites/ufo.PNG", 100 + (x * 50), (50) + rowT * 30);
				entities.add(ufo);
				UFOCount++;
			}
		}
	}

	public void initShip() {
		ship = new ShipEntity(this, "sprites/ship.jpg", 370, 550);
		entities.add(ship);
	}

	// Init number of turns
	public void initNumberShip(int i) {
		if (i == 3) {
			shipNew1 = new ShipEntity(this, "sprites/ship.jpg", 650, 0);
			entities.add(shipNew1);
			shipNew2 = new ShipEntity(this, "sprites/ship.jpg", 700, 0);
			entities.add(shipNew2);
			shipNew3 = new ShipEntity(this, "sprites/ship.jpg", 750, 0);
			entities.add(shipNew3);
		}
		if (i == 2) {
			shipNew2 = new ShipEntity(this, "sprites/ship.jpg", 700, 0);
			entities.add(shipNew2);
			shipNew3 = new ShipEntity(this, "sprites/ship.jpg", 750, 0);
			entities.add(shipNew3);
		}
		if (i == 1) {
			shipNew3 = new ShipEntity(this, "sprites/ship.jpg", 750, 0);
			entities.add(shipNew3);
		}
	}

	// notification from game entity (result of game event)
	public void updateLogic() {
		logicRequiredThisLoop = true;
	}

	// remove an entity from the game
	public void removeEntity(Entity entity) {
		removeList.add(entity);
	}

	// notificatin ufo have killed
	public void notifyUFOKilled() {
		if (flagMusic == 1) {
			MusicFired music_boom = new MusicFired();
			music_boom.start();
		}

		UFOCount--;
		if (UFOCount == 0) {
			if (row > 8) {
				row = 4;
			}
			initUFO(row = row + 1);

		}
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = (Entity) entities.get(i);
			if (entity instanceof UFOEntity) {
				entity.setHorizontalMovement(entity.getHorizontalMovement() * 1.02);
			}
		}
	}

	// create shots
	public void tryToFire() {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return;
		}
		if (flagMusic == 1) {
			MusicFire music_fire = new MusicFire();
			music_fire.start();
		}
		lastFire = System.currentTimeMillis();

		ShotEntity shot = new ShotEntity(this, "sprites/rocket.png", ship.getX() + 10, ship.getY() - 30);
		entities.add(shot);
	}

	// create boom
	public void tryToBoom() {
		long delta1 = System.currentTimeMillis();
		if (ufo.getY() >= 450) {

		} else if (UFOCount >= (row - 1) * 12) {
			if (delta1 - delta2 >= 3000) {
				delta2 = System.currentTimeMillis();
				Entity boom = new BoomEntity(this, "sprites/boom.gif", ship.getX(), ufo.getY());
				entities.add(boom);
			}
		} else if (UFOCount >= (row - 2) * 12) {
			if (delta1 - delta2 >= 1500) {
				delta2 = System.currentTimeMillis();
				Entity boom = new BoomEntity(this, "sprites/boom.gif", ship.getX(), ufo.getY());
				entities.add(boom);
			}
		} else {
			if (delta1 - delta2 >= 700) {
				delta2 = System.currentTimeMillis();
				Entity boom = new BoomEntity(this, "sprites/boom.gif", ship.getX(), ufo.getY());
				entities.add(boom);
			}
		}
	}

	// create background
	public void mainMenu() {
		buttonPlay.setVisible(true);
		buttonQuit.setVisible(true);
		buttonHighScore.setVisible(true);
		buttonMenu.setVisible(false);
		buttonExit.setVisible(false);
		buttonResume.setVisible(false);
		buttonMainMenu.setVisible(false);
		buttonExit2.setVisible(false);
		buttonMusic.setVisible(false);

		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		URL url = getClass().getResource("/sprites/backgroundStart.jpg");
		imageBackgroundStart = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(imageBackgroundStart, 0, 0, 800, 600, this);
		g.dispose();
		strategy.show();
	}

	// start a fresh game, this should clear out any old data
	private void startGame() {
		entities.clear();
		// init entitis with number of rows
		row = 3;
		initUFO(row);
		initShip();
		initNumberShip(3);
		check = null;
		numberTurn = 3;
		valueLoop = null;
		score = 0;
		buttonPlay.setVisible(false);
		buttonQuit.setVisible(false);
		buttonHighScore.setVisible(false);
		leftPressed = false;
		rightPressed = false;
		firePressed = false;
		checkOver = true;
		gameRunning = true;
		flag = true;
		waitingForKey = true;
		this.setFocusable(true);
		gameLoop();
	}

	// the main game loop, this loop is running during all game
	public void gameLoop() {
		long lastLoopTime = System.currentTimeMillis();
		// keep looping round till the game ends
		while (gameRunning) {
			if (flag) {
				// time should move this loop
				long delta = System.currentTimeMillis() - lastLoopTime;
				lastLoopTime = System.currentTimeMillis();
				// create a graphics
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				// new background
				URL url = getClass().getResource("/sprites/stars.gif");
				imageStars = Toolkit.getDefaultToolkit().getImage(url);
				g.drawImage(imageStars, 0, 0, 800, 600, this);
				// create score
				g.setColor(Color.RED);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("SCORE: " + Math.round(score), 20, 20);

				// cycle round asking each entity to move itself
				if (waitingForKey) {
					for (int i = 0; i < entities.size(); i++) {
						Entity entity = (Entity) entities.get(i);
						entity.move(delta);
					}
				}
				tryToBoom();
				// cycle round drawing all the entities, have in the game
				for (int i = 0; i < entities.size(); i++) {
					Entity entity = (Entity) entities.get(i);
					entity.draw(g);
				}
				// handling collision
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
				// remove any entities
				entities.removeAll(removeList);
				removeList.clear();
				//
				if (logicRequiredThisLoop) {
					for (int i = 0; i < entities.size(); i++) {
						Entity entity = (Entity) entities.get(i);
						entity.doLogic();
					}
					logicRequiredThisLoop = false;
				}
				// completed drawing the graphics and flip the buffer over
				g.dispose();
				strategy.show();
				// resolve the movement of the ship
				// first assume the ship isn't moving
				ship.setHorizontalMovement(0);
				// update moving
				if ((leftPressed) && (!rightPressed)) {
					ship.setHorizontalMovement(-speed);
				} else if ((rightPressed) && (!leftPressed)) {
					ship.setHorizontalMovement(speed);
				}
				// if pressing fire, attempt to fire
				if (firePressed) {
					tryToFire();
				}
			} else {
				lastLoopTime = System.currentTimeMillis();
			}
		}
		if (checkOver) {
			gameState = GAME_OVER;
		}
	}

	//
	public String namePlayer() {
		String text;
		do {
			text = JOptionPane.showInputDialog(null, "Nhap ten cua ban(toi da 10 ki tu):", "CONGRATULATION!",
					JOptionPane.WARNING_MESSAGE);
			if (text.length() <= 10) {
			break;
			}
		} while (text.length() > 10);
		return text;
	}

	// set high score
	@SuppressWarnings("static-access")
	public String setHighScore(int score) {
		String[] nameNew = new String[5];
		int[] valueNew = new int[5];
		String[] name = highScore.getName();
		int[] value = highScore.getValue();
		for (int i = 0; i < 5; i++) {
			if (score >= value[i]) {
				int a = 0;
				for (int j = 0; j < i; j++) {
					valueNew[j] = value[a];
					nameNew[j] = name[a];
					a++;
				}
				valueNew[i] = score;
				nameNew[i] = namePlayer();
				for (int j = i + 1; j < 5; j++) {
					valueNew[j] = value[i];
					nameNew[j] = name[i];
					i++;
				}
				highScore.write(nameNew, valueNew);
				return "yes";
			}
		}
		return "no";
	}

	//
	public String CheckScore(String checkLoop) {
		if (checkLoop == "a") {
			return valueLoop;
		} else {
			if (setHighScore(score) == "yes") {
				valueLoop = "yes";
				return "yes";
			} else {
				valueLoop = "no";
				return "no";
			}
		}
	}

	// end game, show player's score and high score
	public void gameOver() {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		URL url = getClass().getResource("/sprites/backgroundStart.jpg");
		imageBackgroundStart = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(imageBackgroundStart, 0, 0, 800, 600, this);
		g.setColor(new Color(0, 255, 0));
		g.setFont(new Font("Arial", Font.BOLD, 60));
		g.drawString("GAME OVER", 215, 170);
		g.setColor(new Color(0, 255, 0));
		if (CheckScore(check) == "yes") {
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString("CONGRATULATION!", 230, 290);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("HIGH SCORE: ", 280, 340);
			g.setColor(Color.RED);
			g.drawString("" + score, 510, 340);
		} else {
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("SCORE: ", 280, 340);
			g.setColor(Color.RED);
			g.drawString("" + score, 510, 340);
		}
		buttonMenu.setVisible(true);
		buttonExit.setVisible(true);
		g.dispose();
		strategy.show();
	}

	// view high score
	private void viewHighScore() {
		buttonPlay.setVisible(false);
		buttonQuit.setVisible(false);
		buttonHighScore.setVisible(false);
		buttonMenu.setVisible(true);
		buttonExit.setVisible(true);
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		URL url = getClass().getResource("/sprites/backgroundStart.jpg");
		imageBackgroundStart = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(imageBackgroundStart, 0, 0, 800, 600, this);
		g.setColor(new Color(25, 25, 112));
		g.fillRect(245, 145, 310, 225);
		g.setColor(new Color(84, 255, 159));
		g.fillRect(250, 150, 300, 35);
		// table score
		g.fillRect(250, 190, 50, 25);
		g.fillRect(305, 190, 120, 25);
		g.fillRect(430, 190, 120, 25);
		// top 1
		g.fillRect(250, 220, 50, 25);
		g.fillRect(305, 220, 120, 25);
		g.fillRect(430, 220, 120, 25);
		// top 2
		g.fillRect(250, 250, 50, 25);
		g.fillRect(305, 250, 120, 25);
		g.fillRect(430, 250, 120, 25);
		// top 3
		g.fillRect(250, 280, 50, 25);
		g.fillRect(305, 280, 120, 25);
		g.fillRect(430, 280, 120, 25);
		// top 4
		g.fillRect(250, 310, 50, 25);
		g.fillRect(305, 310, 120, 25);
		g.fillRect(430, 310, 120, 25);
		// top 5
		g.fillRect(250, 340, 50, 25);
		g.fillRect(305, 340, 120, 25);
		g.fillRect(430, 340, 120, 25);
		g.setColor(new Color(0, 0, 205));
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("High Score", 320, 175);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString("Top", 260, 210);
		g.drawString("Name", 340, 210);
		g.drawString("Score", 465, 210);
		String[] name = highScore.getName();
		int[] value = highScore.getValue();
		int x = 0;
		g.setColor(new Color(238, 44, 44));
		for (int i = 0; i < 5; i++) {
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString("" + (i + 1) + "      " + name[i], 270, 240 + x);
			g.drawString("" + value[i], 435, 240 + x);
			x = x + 30;
		}
		g.dispose();
		strategy.show();
	}

	// create button play
	private JButton createButtonPlay(String actionPlay, String buttonNamePlay) {
		URL url = getClass().getResource("/sprites/buttonPlay.png");
		imageButtonPlay = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonPlay);
		buttonPlay = new JButton(buttonNamePlay, icon);
		buttonPlay.setBounds(300, 250, 184, 48);
		buttonPlay.setActionCommand(actionPlay);
		buttonPlay.addActionListener(this);
		return buttonPlay;
	}

	// create button view high score
	private JButton createButtonHighScore(String actionHighScore, String buttonNameHighScore) {
		URL url = getClass().getResource("/sprites/highscore.png");
		imageButtonPlay = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonPlay);
		buttonHighScore = new JButton(buttonNameHighScore, icon);
		buttonHighScore.setBounds(300, 330, 184, 48);
		buttonHighScore.setActionCommand(actionHighScore);
		buttonHighScore.addActionListener(this);
		return buttonHighScore;
	}

	// create button quit
	private JButton createButtonQuit(String actionQuit, String buttonNameQuit) {
		URL url = getClass().getResource("/sprites/buttonQuit.png");
		imageButtonQuit = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonQuit);
		buttonQuit = new JButton(buttonNameQuit, icon);
		buttonQuit.setBounds(300, 410, 184, 48);
		buttonQuit.setActionCommand(actionQuit);
		buttonQuit.addActionListener(this);
		return buttonQuit;
	}

	// create button menu
	private JButton createButtonMenu(String actionMenu, String buttonNameMenu) {
		URL url = getClass().getResource("/sprites/mainmenu.png");
		imageButtonMenu = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonMenu);
		buttonMenu = new JButton(buttonNameMenu, icon);
		buttonMenu.setBounds(20, 530, 184, 48);
		buttonMenu.setActionCommand(actionMenu);
		buttonMenu.addActionListener(this);
		return buttonMenu;
	}

	// create returnMainMenu
	private JButton createButtonReturnMenu(String actionReturnMenu, String buttonNameReturnMenu) {
		URL url = getClass().getResource("/sprites/mainmenu.png");
		imageButtonMenu = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonMenu);
		buttonMainMenu = new JButton(buttonNameReturnMenu, icon);
		buttonMainMenu.setBounds(320, 270, 170, 46);
		buttonMainMenu.setActionCommand(actionReturnMenu);
		buttonMainMenu.addActionListener(this);
		return buttonMainMenu;
	}

	// create button quit
	private JButton createButtonExit(String actionExit, String buttonNameExit) {
		URL url = getClass().getResource("/sprites/quit.png");
		imageButtonQuit = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonQuit);
		buttonExit = new JButton(buttonNameExit, icon);
		buttonExit.setBounds(600, 530, 170, 46);
		buttonExit.setActionCommand(actionExit);
		buttonExit.addActionListener(this);
		return buttonExit;
	}

	// create resumebutton
	private JButton createButtonResume(String actionResume, String buttonNameResume) {
		URL url = getClass().getResource("/sprites/resume.png");
		imageResume = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageResume);
		buttonResume = new JButton(buttonNameResume, icon);
		buttonResume.setBounds(320, 200, 170, 46);
		buttonResume.setActionCommand(actionResume);
		buttonResume.addActionListener(this);
		return buttonResume;

	}

	// create button exit 2
	private JButton createButtonExit2(String actionExit2, String buttonNameExit) {
		URL url = getClass().getResource("/sprites/quit.png");
		imageButtonPlay = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonPlay);
		buttonExit2 = new JButton(buttonNameExit, icon);
		buttonExit2.setBounds(320, 410, 170, 46);
		buttonExit2.setActionCommand(actionExit);
		buttonExit2.addActionListener(this);
		return buttonExit2;
	}

	// button music
	private JButton createButtonMusic(String actionMusic, String buttonNameMusic) {
		URL url = getClass().getResource("/sprites/musicIcon.png");
		imageMusic = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageMusic);
		buttonMusic = new JButton(buttonNameMusic, icon);
		buttonMusic.setBounds(320, 340, 170, 46);
		buttonMusic.setActionCommand(actionMusic);
		buttonMusic.addActionListener(this);
		return buttonMusic;
	}

	// pause
	public void pause() {
		buttonMusic.setVisible(true);
		buttonMainMenu.setVisible(true);
		buttonResume.setVisible(true);
		buttonExit2.setVisible(true);
	}

	// continue game
	public void continueGame() {
		buttonMusic.setVisible(false);
		buttonResume.setVisible(false);
		buttonMainMenu.setVisible(false);
		buttonExit2.setVisible(false);
	}

	// event capture
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (actionPlay.equals(command)) {
			gameState = IN_GAME;
		}
		if (actionHighScore.equals(command)) {
			gameState = HIGH_SCORE;
		}
		if (actionMenu.equals(command) || actionReturnMenu.equals(command)) {
			gameState = MAIN_MENU;
		}
		if (actionQuit.equals(command) || actionExit.equals(command) || actionExit2.equals(command)) {
			System.exit(0);
		}
		if (actionresume.equals(command)) {
			flag = true;
			continueGame();
		}
		if (actionReturnMenu.equals(command)) {
			gameRunning = false;
			checkOver = false;
			gameState = MAIN_MENU;
		}
		if (actionMusic.equals(command)) {
			if (flagMusic == 1) {
				flagMusic = 0;
				JOptionPane.showMessageDialog(this, "Da tat am thanh");

			} else {
				flagMusic = 1;
				JOptionPane.showMessageDialog(this, "Da bat am thanh");
			}
		}
	}

	// a class to handle keyboard input from the user
	private class KeyInputHandler extends KeyAdapter {
		// notification that a key has been pressed
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_B) {
				firePressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				flag = false;
				pause();
			}
		}

		// notification that a key has been released.
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_B) {
				firePressed = false;
			}
		}
	}

	// a switch to control game
	public void mainGameLoop() {
		while (true) {
			switch (gameState) {
			case MAIN_MENU:
				mainMenu();
				break;
			case HIGH_SCORE:
				viewHighScore();
				break;
			case IN_GAME:
				startGame();
				break;
			case GAME_OVER:
				gameOver();
				check = "a";
				break;
			default:
				break;
			}
		}
	}

	// main
	public static void main(String argv[]) {
		Game game = new Game();
		game.mainGameLoop();
	}
}
