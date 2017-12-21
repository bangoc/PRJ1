package project.spaceinvader;

// The entity that represents the player's ship
public class ShipEntity extends Entity {
	private Game game;

	// Create a new entity to represent the player's ship
	public ShipEntity(Game game, String ref, int x, int y) {
		super(ref, x, y);
		this.game = game;
	}

	// Request that the ship move itself based on an elapsed ammount of time
	public void move(long delta) {
		if ((dx < 0) && (x < 10)) {
			return;
		}
		if ((dx > 0) && (x > 750)) {
			return;
		}
		super.move(delta);
	}
	// Notification that the player's ship has collided with something
	public void collidedWith(Entity other) {
		if (other instanceof UFOEntity) {
			game.gameRunning = false;
		}
	}
}
