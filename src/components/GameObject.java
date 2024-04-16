package components;

/**
 * This class represents properties that the game objects depend on.
 * 
 * @author Rithvik Muthyalapati
 * @version Final
 */

import java.awt.Rectangle;

import processing.core.PApplet;

public abstract class GameObject {

	protected float x, y;
	protected float velX, velY;

	/**
	 * This constructor takes in the x and y coordinate of this game object.
	 * 
	 * @param x The x-coordinate of this game object.
	 * @param y The y-coordinate of this game object.
	 */
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws this game object with specified coordinates and size.
	 * 
	 * @param drawer The PApplet object to be used for drawing this game object.
	 */
	public abstract void draw(PApplet drawer);

	/**
	 * Gets the rectangular boundary around this game object.
	 * 
	 * @return Returns a new Rectangle with the x-position and y-position of this
	 *         game object and also the width and height.
	 */
	public abstract Rectangle getBounds();

	/**
	 * Sets the horizontal velocity of the game object.
	 * 
	 * @param velX The value to be set as the new horizontal velocity.
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * Sets the vertical velocity of this game object.
	 * 
	 * @param velY The value to be set as the new vertical velocity.
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
}
