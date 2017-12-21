package project.spaceinvader;

// An entity which represents one of space invader
public class UFOEntity extends Entity {
	// The speed at which the ufo moves horizontally
	private double movespeed = 100;
	private Game game;

	// Create a new ufo entity
	public UFOEntity(Game game, String ref, int x, int y) {
		super(ref, x, y);
		this.game = game;
		dx = -movespeed;
	}

	// Request that this ufo moved based on time elapsed
	public void move(long delta) {
		if ((dx < 0) && (x < 10)) {
			game.updateLogic();
		}
		if ((dx > 0) && (x > 750)) {
			game.updateLogic();
		}
		super.move(delta);
	}
	// Update the game logic related to ufo
	public void doLogic() {
		dx = -dx;
		y += 15;
		if (y > 570) {
			game.gameRunning = false;
		}
	}

	public void collidedWith(Entity other) {
	}
}
