package project.spaceinvader;

//An entity representing a shot fired by the player's ship
public class ShotEntity extends Entity {
	// The vertical speed at which the player's shot moves
	private double moveSpeed = -300;
	private Game game;
	// True if this shot has been "used"
	private boolean used = false;
	// Write high score
	private HighScore highScore;

	// Create a new shot from the player
	public ShotEntity(Game game, String sprite, int x, int y) {
		super(sprite, x, y);
		this.game = game;
		dy = moveSpeed;
	}

	// Request that this shot moved based on time elapsed
	public void move(long delta) {
		super.move(delta);
		if (y < -50) {
			game.removeEntity(this);
		}
	}

	// Notification that this shot has collided with another entity
	public void collidedWith(Entity other) {
		if (used) {
			return;
		}
		if (other instanceof UFOEntity) {
			game.removeEntity(this);
			game.removeEntity(other);
			game.notifyUFOKilled();
			game.score++;
			used = true;
		}
	}
}
