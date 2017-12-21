package project.spaceinvader;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	// The current speed of this entity horizontally
	protected double dx;
	// The current speed of this entity vertically
	protected double dy;
	// The current x location of this entity
	protected double x;
	// The current y location of this entity
	protected double y;
	protected Sprite sprite;
	// The rectangle used for this entity during collisions resolution
	private Rectangle me = new Rectangle();
	// The rectangle used for other entities during collision resolution
	private Rectangle him = new Rectangle();

	// Construct a entity based on a sprite image and a location.
	public Entity(String ref, int x, int y) {
		this.sprite = SpriteStore.get().getSprite(ref);
		this.x = x;
		this.y = y;
	}

	// Update the location of the entity based on move speeds
	public void move(long delta) {
		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}

	// Set the horizontal speed of this entity
	public void setHorizontalMovement(double dx) {
		this.dx = dx;
	}

	// Set the vertical speed of this entity
	public void setVerticalMovement(double dy) {
		this.dy = dy;
	}

	// Get the horizontal speed of this entity
	public double getHorizontalMovement() {
		return dx;
	}

	// Get the vertical speed of this entity
	public double getVerticalMovement() {
		return dy;
	}

	public void doLogic() {
	}

	// Draw this entity to the graphics context provided
	public void draw(Graphics g) {
		sprite.draw(g, (int) x, (int) y);
	}

	// Get the x location of this entity
	public int getX() {
		return (int) x;
	}

	// Get the y location of this entity
	public int getY() {
		return (int) y;
	}

	// Check if this entity collised with another
	public boolean collidesWith(Entity other) {
		me.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
		him.setBounds((int) other.x, (int) other.y, other.sprite.getWidth(), other.sprite.getHeight());
		return me.intersects(him);
	}

	public abstract void collidedWith(Entity other);
}
