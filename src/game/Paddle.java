package game;

/**
 * This class represents and creates a paddle which the player controls. It's in
 * charge of drawing the paddle and has the paddle's behaviors.
 * 
 * @author Rithvik Muthyalapati
 * @version Final
 */

import java.awt.Rectangle;

import components.GameObject;

import processing.core.PApplet;

public class Paddle extends GameObject {

	public static int lives;
	private int paddleWidth;
	private int paddleHeight;
	private int paddleSpeed;

	/**
	 * Constructor for the paddle.
	 * 
	 * @param x The x-coordinate on the paddle.
	 * @param y The y-coordinate on the paddle.
	 */
	public Paddle(int x, int y) {
		super(x, y);
		paddleWidth = 98;
		paddleHeight = 12;
		paddleSpeed = 50;
		
	}

	@Override
	public void draw(PApplet drawer) {
		drawer.fill(255);
		drawer.rect((int) x, (int) y, paddleWidth, paddleHeight);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, paddleWidth, paddleHeight);
	}

	/**
	 * Gets the width of the paddle.
	 * 
	 * @return Returns the width of the paddle.
	 */
	public int getPaddleWidth() {
		return paddleWidth;
	}

	/**
	 * Gets the speed(how many pixels it moves) of the paddle.
	 * 
	 * @return Returns the speed of the paddle.
	 */
	public int getSpeed() {
		return paddleSpeed;
	}
}
