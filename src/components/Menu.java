package components;

/**
 * This class creates an eye-appealing menu screen for our game. It ensures the
 * user goes to the correct panel and is able to clearly see all the buttons and
 * text that appears.
 * 
 * @author Rithvik Muthyalapati
 * 
 * @version Final
 */

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import components.Game.STATE;
import processing.core.PApplet;

public class Menu {

	Clip menuClip;
	Clip gameClip;
	private int score;
	private int highScore;

	/**
	 * Menu constuctor.
	 * 
	 * @param score     Current score in the game.
	 * @param highScore Highest score when played the game.
	 */
	public Menu(int score, int highScore) {
		this.score = score;
		this.highScore = highScore;
	}

	/**
	 * This is the most important method in this class. It generates and creates all
	 * of the buttons and panels which are all user-interactive. Keeps track of
	 * where the user is located in the menu.
	 * 
	 * @param drawer PApplet object which allows drawing the menu, select, help,
	 *               end, and win screens.
	 */
	public void draw(PApplet drawer) {

		switch (Game.gameState) {
		case Menu:
			drawer.background(0);
			drawer.fill(0, 255, 255);
			drawer.textSize(40);
			drawer.text("Brick Destroyer", 250, 70);
			drawer.rect(345, 150, 100, 35); // Play button
			drawer.rect(345, 250, 100, 35); // Help button
			drawer.rect(345, 350, 100, 35); // Quit button
			drawer.fill(0);
			drawer.textSize(20);
			drawer.text("Play", 375, 175);
			drawer.text("Help", 375, 275);
			drawer.text("Quit", 375, 375);
			break;
		case Select:
			drawer.background(0);
			drawer.fill(0, 255, 255);
			drawer.textSize(40);
			drawer.text("Select Difficulty", 250, 70);
			drawer.rect(345, 150, 100, 35); // Easy button
			drawer.rect(345, 250, 100, 35); // Medium button
			drawer.rect(345, 350, 100, 35); // Hard button
			drawer.fill(0);
			drawer.textSize(20);
			drawer.text("Easy", 375, 175);
			drawer.text("Medium", 360, 275);
			drawer.text("Hard", 373, 375);
			break;
		case End:
			drawer.background(0);
			drawer.textSize(32);
			drawer.fill(255, 0, 0);
			drawer.text("Game Over!", 310, 100);
			drawer.text("Score: " + score, 320, 150);
			drawer.text("Highscore: " + highScore, 320, 200);
			drawer.rect(345, 350, 100, 35); // Restart button
			drawer.fill(0);
			drawer.textSize(20);
			drawer.text("Restart", 360, 375);
			break;
		case Help:
			drawer.background(0);
			drawer.fill(0, 255, 255);
			drawer.text("Use the left and right arrow keys to move the paddle left and right.", 50, 100);
			drawer.text("You must prevent the ball from touching the ground.", 50, 200);
			drawer.text("To win, you must bounce the ball towards the bricks and destroy all of them.", 50, 300);
			drawer.rect(345, 390, 100, 35); // Back button
			drawer.fill(0);
			drawer.textSize(20);
			drawer.text("Back", 375, 415);
			break;
		case Win:
			drawer.background(0);
			drawer.textSize(32);
			drawer.fill(0, 255, 0);
			drawer.text("You Win!", 330, 100);
			drawer.text("Score: " + score, 320, 150);
			drawer.text("Highscore: " + highScore, 320, 200);
			drawer.rect(345, 350, 100, 35); // Restart button
			drawer.fill(0);
			drawer.textSize(20);
			drawer.text("Restart", 360, 375);
			break;
		default:
			Game.gameState = STATE.Menu;
		}
	}

	/**
	 * Background music for the menu.
	 */
	public void playBackgroundSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/background.wav"));
			menuClip = AudioSystem.getClip();
			menuClip.open(audioInputStream);
			menuClip.start();
			menuClip.loop(Clip.LOOP_CONTINUOUSLY);
			if (Game.gameState == STATE.Game) {
				menuClip.stop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Game over sound when player loses the game.
	 */
	public void playGameOverSound() {
		Clip clip;
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/gameover.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Win sound when the player wins the game.
	 */
	public void playWinSound() {
		Clip clip;
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/win.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Plays the game music.
	 * 
	 */
	public void playLevelSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/game.wav"));
			if (Game.gameState == STATE.Game) {
				gameClip = AudioSystem.getClip();
				gameClip.open(audioInputStream);
				gameClip.start();
				gameClip.loop(Clip.LOOP_CONTINUOUSLY);
			} else if (Game.gameState == STATE.Menu) {
				gameClip.stop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}