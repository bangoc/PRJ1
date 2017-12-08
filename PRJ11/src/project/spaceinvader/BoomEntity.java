package project.spaceinvader;

public class BoomEntity extends Entity {
	private Game game;
	private boolean used = false;
	// The vertical speed at which the boom moves
	private double moveSpeed = 100;

	// Create a new entity to represent the boom
	public BoomEntity(Game game, String sprite, int x, int y) {
		super(sprite, x, y);
		this.game = game;
		dy = moveSpeed;
	}

	// Request that this boom moved based on time elapsed
	public void move(long delta) {
		super.move(delta);
		if (y > 650) {
			game.removeEntity(this);
		}
	}

	// Notification that this boom has collided with ship
	public void collidedWith(Entity other) {
		if (used) {
			return;
		}
		if (other instanceof ShipEntity) {
			game.gameOver();
			game.gameRunning = false;
			used = true;
		}
	}
}
