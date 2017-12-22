package project.spaceinvader;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
	private Image image;

	// Create a new sprite based on an image
	public Sprite(Image image) {
		this.image = image;
	}

	// Get the width of the drawn sprite
	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
	}

	// Get the height of the drawn sprite
	public int getHeight() {
		return image.getHeight(null);
	}
	// Draw the sprite into the graphics context provided
	public int getWidth() {
		return image.getWidth(null);
	}
}
