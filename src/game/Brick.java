package game;

/**
 * This class represents a single brick and its properties.
 *
 * @author Atharv Koratkar
 * @version Final
 */

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

import components.GameObject;

import processing.core.PApplet;

public class Brick extends GameObject {

	private int brickWidth, brickHeight;
	private boolean visible;
	private Color brickColor;

	/**
	 * Constructor for the brick.
	 * 
	 * @param x       The x-coordinate of the brick.
	 * @param y       The y-coordinate of the brick.
	 * @param visible Boolean variable that tells if the brick is visible or not.
	 */
	public Brick(float x, float y, boolean visible) {
		super(x, y);
		brickWidth = 90;
		brickHeight = 20;
		this.visible = visible;
		brickColor = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
	}

	/**
	 * Gets the state of the current brick, whether it's visible or not.
	 * 
	 * @return Returns the visibility state of the brick.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Method simply allows us to set the visiblity of the brick.
	 * 
	 * @param visible New visibility state of the brick.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void draw(PApplet drawer) {
		if (visible) {
			drawer.fill(brickColor.getRed(), brickColor.getGreen(), brickColor.getBlue());
			drawer.rect(x, y, brickWidth, brickHeight);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, brickWidth, brickHeight);
	}

	/**
	 * Gets the width of the brick.
	 * 
	 * @return Returns the width of the brick.
	 */
	public int getBrickWidth() {
		return brickWidth;
	}

	/**
	 * Gets the height of the brick.
	 * 
	 * @return Returns the height of the brick.
	 */
	public int getBrickHeight() {
		return brickHeight;
	}

	/**
	 * Gets the color of the brick.
	 * 
	 * @return Returns the color of the brick.
	 */
	public Color getColor() {
		return brickColor;
	}
}
