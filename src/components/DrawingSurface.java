package components;

/**
 * This is the most important class in our game. This class is in charge of
 * drawing the game. This class has all of the essential game mechanics for the game. 
 * These include paddle movement, ball collision with everything, and more.
 * 
 * @author Atharv Koratkar and Rithvik Muthyalapati
 * @version Final
 */

import game.Ball;
import game.Brick;
import game.Paddle;

import java.awt.Color;

import components.Game;
import components.Game.STATE;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	private Paddle paddle;
	private Ball ball;
	private Menu menu;
	private Brick[][] bricks;
	private float windowWidth, windowHeight;
	private int paddleX, paddleY, paddleWidthX;
	private int ballX, ballY;
	private int velX, velY;
	private PImage gameBackground;
	private boolean play;
	private boolean intersected;
	private boolean isTouchingTop, isTouchingRight, isTouchingLeft;
	private boolean drawBricksInitially = false;
	private Color intersectColor;
	private int score, highScore = 0;

	/**
	 * This method sets up the game.
	 */
	public void setup() {
		restartGame(true);
	}

	/**
	 * This method simply restarts the game back it's original state. It initializes
	 * a lot of paramaters to be used later in the class.
	 * 
	 * @param firstGame Boolean which detects if you have played the first game
	 *                  since the application has been opened.
	 */
	public void restartGame(boolean firstGame) {
		paddleX = 364;
		paddleY = 450;
		ballX = 410;
		ballY = 330;
		velX = 4;
		velY = 4;
		intersectColor = new Color(255, 255, 255);

		gameBackground = loadImage("images/game_background.jpg"); // Loads the background image into gameBackground

		play = false;
		intersected = false;
		if (firstGame) { // Checks if the player has played their first game since the program was
							// executed
			score = 0;
		}

		isTouchingTop = false;
		isTouchingLeft = false;
		isTouchingRight = false;

		bricks = new Brick[8][8];
		drawBricksInitially = true;

		menu = new Menu(score, highScore);
		menu.playBackgroundSound();
	}

	/**
	 * This method is in charge of drawing the paddle, the bricks and the ball. It
	 * also calls methods within the class to make the paddle and also the ball
	 * work. It creates multiple objects including the bricks, paddle and the ball.
	 */
	public void draw() {
		windowWidth = width / 800F;
		windowHeight = height / 500F;

		scale(windowWidth, windowHeight);

		if (Game.gameState == STATE.Game) { // Checks if the state of the program is in its game state
			image(gameBackground, 0, 0);
			background(gameBackground);

			paddle = new Paddle(paddleX, paddleY);
			ball = new Ball(ballX, ballY, velX, velY, intersectColor);
			paddle.draw(this);
			ball.draw(this);

			if (drawBricksInitially) {
				drawBrick();
				drawBricksInitially = false;
			}
			redrawBrick();

			fill(250, 250, 250);
			text("Lives: ", 20, 40);
			text("Score: " + score, 690, 40);
			fill(255);
			for (int i = 0; i < Paddle.lives; i++) {
				ellipse(30 * i + 95, 33, 20, 20);
			}

			animateGame();

			boolean restart = false;

			if (score > highScore) {
				highScore = score;
			}

			if (Paddle.lives == 0) {
				Game.gameState = STATE.End;
				menu.gameClip.stop();
				menu.playGameOverSound();
				restart = true;
			}

			if (gameWin()) {
				Game.gameState = STATE.Win;
				menu.gameClip.stop();
				menu.playWinSound();
				restart = true;
			}
			if (restart) {
				restartGame(false);
			}
		} else {
			menu.draw(this);
			score = 0;
		}
	}

	/**
	 * This method resets the ball and paddle to their original position.
	 */
	public void resetBallPaddle() {
		paddleX = 364;
		paddleY = 450;
		ballX = 410;
		ballY = 330;
	}

	/**
	 * This method redraws the brick when called.
	 */
	private void redrawBrick() {
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length; j++) {
				bricks[i][j].draw(this);
			}
		}
	}

	/**
	 * This method loops through the 2D Array of bricks and draws all the bricks in
	 * the correct position with proportional sizes.
	 */
	private void drawBrick() {
		int x = 40;
		int y = 70;
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length; j++) {
				bricks[i][j] = new Brick(x, y, true);
				bricks[i][j].draw(this);
				x += bricks[i][j].getBrickWidth() + 1;
			}
			y += bricks[i][0].getBrickHeight() + 1;
			x = 40;
		}
	}

	/**
	 * This method is in charge of the movement of the paddle. It codes the basic
	 * movement from left to right and ensures that the paddle does not go off
	 * screen.
	 */
	public void keyPressed() {
		paddleWidthX = paddleX + paddle.getPaddleWidth();
		if (key == CODED) {
			play = true;
			if (keyCode == RIGHT) {
				if (paddleWidthX <= width) {
					if (width - paddleWidthX >= paddle.getSpeed()) {
						paddleX += paddle.getSpeed();
					} else {
						paddleX += width - paddleWidthX;
					}
				}
			} else if (keyCode == LEFT) {
				if (paddleX > 0) {
					if (paddleX > paddle.getSpeed()) {
						paddleX -= paddle.getSpeed();
					} else {
						paddleX = 0;
					}
				}
			}
		}
	}

	/**
	 * This method simply animates the ball. It shows the animation of the ball
	 * bouncing off the paddle and the walls. It also detects the collision between
	 * the bricks and the ball itself. The method ensures the ball doesn't go off
	 * the screen.
	 */
	public void animateGame() {
		if (play) {
			if (ball.getBounds().intersects(paddle.getBounds())) { // Checks if the ball has intersected the paddle
				intersected = true;
				ball.playBounceSound();
			}

			if (ballX <= 10) {
				isTouchingLeft = true;
			}

			if (ballY <= 10) {
				isTouchingTop = true;
			}

			if (ballX >= width - 10) {
				isTouchingRight = true;
			}

			for (int i = 0; i < bricks.length; i++) {
				for (int j = 0; j < bricks[i].length; j++) {
					Brick oneBrick = bricks[i][j];
					if (ball.getBounds().intersects(oneBrick.getBounds()) && oneBrick.isVisible()) {
						intersectColor = oneBrick.getColor();
						oneBrick.setVisible(false);
						score += 5;
						if (ballX > 410 && oneBrick.y > 480) {
							ball.velX = -ball.velX;
						} else {
							ball.velY = -ball.velY;
						}
					}
				}
			}

			// direction assumptions +ve velX means going right +ve velY means going down
			// -velX means going left ( right to left) and -velY means going up away from
			// paddle
			if (intersected) {
				if (ball.velX > 0) {
					ball.velX = 1 * Math.abs(ball.velX);
				} else {
					ball.velX = -1 * Math.abs(ball.velX);
				}
				ball.velY = -1 * Math.abs(ball.velY);
				intersected = false;
			}

			if (isTouchingLeft) {

				ball.velX = 1 * Math.abs(ball.velX);

				if (ball.velY > 0) {
					ball.velY = 1 * Math.abs(ball.velY);
				} else {
					ball.velY = -1 * Math.abs(ball.velY);
				}
				isTouchingLeft = false;
			}
			if (isTouchingTop) {

				if (ball.velX > 0) {
					ball.velX = 1 * Math.abs(ball.velX);
				} else {
					ball.velX = -1 * Math.abs(ball.velX);
				}

				ball.velY = 1 * Math.abs(ball.velY);
				isTouchingTop = false;
			}

			if (isTouchingRight) {

				ball.velX = -1 * Math.abs(ball.velX);

				if (ball.velY > 0) {
					ball.velY = 1 * Math.abs(ball.velY);
				} else {
					ball.velY = -1 * Math.abs(ball.velY);
				}
				isTouchingRight = false;
			}

			// Checks if the ball goes below the paddle
			if (ballY > 510) {
				Paddle.lives--;
				play = false;
				if (Paddle.lives > 0) {
					ball.playDeathSound();
					resetBallPaddle();
				}
			}

			// calculating the new position of balls x y coord
			// ball.velX = (int) (ball.velX);
			// ball.velY = (int) (ball.velY);

			velX = (int) ball.velX;
			velY = (int) ball.velY;

			ballX = (int) (ballX + ball.velX);
			ballY = (int) (ballY + ball.velY);
		}
	}

	/**
	 * Checks if the game is finished with a boolean method.
	 * 
	 * @return true if game is over, false if game is not over.
	 */
	public boolean gameWin() {
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length; j++) {
				Brick oneBrick = bricks[i][j];
				if (oneBrick.isVisible()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method checks if the user has interacted or pressed any of the buttons
	 * on the menu. If it has, then it switches to the respective screen.
	 */
	public void mousePressed() {
		if (mouseX >= 345 && mouseX <= 445 && mouseY >= 145 && mouseY <= 185 && Game.gameState == STATE.Menu) {
			// Play button
			Game.gameState = STATE.Select;
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 240 && mouseY <= 270 && Game.gameState == STATE.Menu) {
			// Help button
			Game.gameState = STATE.Help;
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 375 && mouseY <= 410 && Game.gameState == STATE.Help) {
			// Back button
			Game.gameState = STATE.Menu;
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 335 && mouseY <= 370 && Game.gameState == STATE.Menu) {
			// Quit button
			System.exit(1);
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 335 && mouseY <= 370 && Game.gameState == STATE.End) {
			// Fail Restart button
			Game.gameState = STATE.Menu;
			Paddle.lives = 3;
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 335 && mouseY <= 370 && Game.gameState == STATE.Win) {
			// Win Restart button
			Game.gameState = STATE.Menu;
			Paddle.lives = 3;
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 145 && mouseY <= 185 && Game.gameState == STATE.Select) {
			// Easy button
			Game.gameState = STATE.Game;
			Paddle.lives = 3;
			menu.menuClip.stop();
			menu.playLevelSound();
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 240 && mouseY <= 270 && Game.gameState == STATE.Select) {
			// Medium button
			Game.gameState = STATE.Game;
			Paddle.lives = 2;
			velX = 5;
			velY = 5;
			menu.menuClip.stop();
			menu.playLevelSound();
		} else if (mouseX >= 345 && mouseX <= 445 && mouseY >= 335 && mouseY <= 370 && Game.gameState == STATE.Select) {
			// Hard button
			Game.gameState = STATE.Game;
			Paddle.lives = 1;
			velX = 6;
			velY = 6;
			menu.menuClip.stop();
			menu.playLevelSound();
		}
	}
}