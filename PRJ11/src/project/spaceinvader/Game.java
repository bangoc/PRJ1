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

public class Game extends Canvas implements ActionListener {
	public double score;// score of player
	private int UFOCount;// number of UFO on screen
	public JFrame display;
	private ImageIcon icon;
	private Entity ufo, ship; // object ufo and ship
	private BufferStrategy strategy;// the stragey that allows us to use accelerate page flipping
	private static HighScore highScore;// highscore of player
	public JButton buttonPlay, buttonQuit;// button
	// The list of all the entities that exist in game
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	// The list of entities that need to be removed from the game this loop
	private ArrayList<Entity> removeList = new ArrayList<Entity>();
	private String actionPlay = "play";
	private String actionQuit = "quit";
	private long lastFire = 0;// the time at which last fired a shot
	private static int row = 3;// the rows of ufo on screen
	private long firingInterval = 700;// the interval between fired shot (ms)
	private final static double speed = 300.0; // speed of ship (pixels/sec)
	private final static int IN_GAME = 0; // const to start game looping
	private final static int MAIN_MENU = 1;// const to open main menu
	private final static int GAME_OVER = 2; // const to end game
	private int gameState = MAIN_MENU;
	public boolean gameRunning = false;// if false the game loop is not running
	public boolean firePressed = false;// ship are firing if true
	public boolean leftPressed = false;// left key is currently pressed if true
	public boolean rightPressed = false;// right key is currently pressed if true
	private boolean waitingForKey = true;// if true, game start
	private boolean logicRequiredThisLoop = false;// result of a game event
	private Image imageBackgroundStart, imageButtonPlay, imageButtonQuit, imageStars;// image of game
	//
//	public MusicShoot musicShoot = new MusicShoot();
	// private MusicBoom musicBoom = new MusicBoom();

	// construct game
	public MusicStart music_start = new MusicStart();
	public Game() {
		// create a JFrame to contain game
		display = new JFrame(
				"-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-GAME SPACE INAVDER-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		// create a JPanel
		JPanel panel = (JPanel) display.getContentPane();
		panel.setPreferredSize(new Dimension(790, 595));
		panel.add(createButtonPlay(actionPlay, "play"));
		panel.add(createButtonQuit(actionQuit, "quit"));
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
		// init entitis with number of rows
		initEntities(row);
	}

	// Initialise the starting state of the entities (ship and ufo)
	private void initEntities(int rowT) {
		ship = new ShipEntity(this, "sprites/ship.jpg", 370, 550);
		entities.add(ship);

		UFOCount = 0;
		for (rowT = 0; rowT < row; rowT++) {
			for (int x = 0; x < 12; x++) {
				ufo = new UFOEntity(this, "sprites/ufo.PNG", 100 + (x * 50), (50) + rowT * 30);
				entities.add(ufo);
				UFOCount++;
			}
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
		try {
			
		} catch (Exception e) {
			System.out.println("error");
		}
		MusicFired music_boom = new MusicFired();
		music_boom.start();
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

	// create shots
	public void tryToFire() {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return;
		}
		lastFire = System.currentTimeMillis();
		MusicFire music_fire = new MusicFire();
		music_fire.start();
		ShotEntity shot = new ShotEntity(this, "sprites/rocket.png", ship.getX() + 10, ship.getY() - 30);
		entities.add(shot);
	}

	// create boom
	public void tryToBoom() {
		Entity boom = new BoomEntity(this, "sprites/boom.gif", ship.getX(), ufo.getY());
		entities.add(boom);
	}

	// create background
	public void mainMenu() {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		URL url = getClass().getResource("/sprites/backgroundStart.jpg");
		imageBackgroundStart = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(imageBackgroundStart, 0, 0, 800, 600, this);
		g.dispose();
		strategy.show();
	}

	// start a fresh game, this should clear out any old data
	private void startGame() {
//		music_start.start();
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
		waitingForKey = true;
		this.setFocusable(true);
	}

	// the main game loop, this loop is running during all game
	public void gameLoop() {
		long lastLoopTime = System.currentTimeMillis();
		// keep looping round till the game ends
		while (gameRunning) {
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
			g.drawString("SCORE: " + Math.round(score), 350, 20);
			// create high score
			g.drawString("HIGH SCORE: " + Math.round(highScore.Read()), 0, 20);
			// cycle round asking each entity to move itself
			if (waitingForKey) {
				for (int i = 0; i < entities.size(); i++) {
					Entity entity = (Entity) entities.get(i);
					entity.move(delta);
				}
			}
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
			// pause for a bit
			try {
				Thread.sleep(5);
				Thread.currentThread();
			} catch (Exception e) {
			}
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName);
		}
		gameState = GAME_OVER;
	}

	// end game, show player's score and high score
	public void gameOver() {
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

	// create button play
	private JButton createButtonPlay(String action1, String buttonName1) {
		URL url = getClass().getResource("/sprites/buttonPlay.png");
		imageButtonPlay = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonPlay);
		buttonPlay = new JButton(buttonName1, icon);
		buttonPlay.setBounds(300, 300, 190, 48);
		buttonPlay.setActionCommand(action1);
		buttonPlay.addActionListener(this);
		return buttonPlay;
	}

	// create button quit
	private JButton createButtonQuit(String action2, String buttonName2) {
		URL url = getClass().getResource("/sprites/buttonQuit.png");
		imageButtonQuit = Toolkit.getDefaultToolkit().getImage(url);
		icon = new ImageIcon(imageButtonQuit);
		buttonQuit = new JButton(buttonName2, icon);
		buttonQuit.setBounds(300, 400, 190, 48);
		buttonQuit.setActionCommand(action2);
		buttonQuit.addActionListener(this);
		return buttonQuit;
	}

	// event capture
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (actionPlay.equals(command)) {
			startGame();
		}
		if (actionQuit.equals(command)) {
			System.exit(0);
		}
	}

	// tam dung game
	private void pause() {

		// Thread.sleep(firingInterval);
		// Thread.sleep(90000);
		buttonPlay.setVisible(true);
		buttonQuit.setVisible(true);

	}

	// continue
	public void continueGame() {
		buttonPlay.setVisible(false);
		buttonQuit.setVisible(false);
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
//				musicShoot.run();
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
//				musicShoot.stop();
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

	// main
	public static void main(String argv[]) {
		Game game = new Game();
		game.mainGameLoop();
	}
}
