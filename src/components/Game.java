package components;

/**
 * This class creates and initiates the game.
 * 
 * @author Atharv Koratkar and Rithvik Muthyalapati
 * @version Final
 */

import components.Window;

public class Game {

	private static final int WIDTH = 800, HEIGHT = 500;

	/**
	 * This enumeration holds the constant game states.
	 */
	public enum STATE {
		Menu, Select, Help, Game, End, Win;
	}

	public static STATE gameState = STATE.Menu;

	/**
	 * This is a no-args constructor that initiates the game.
	 */
	public Game() {
		new Window(WIDTH, HEIGHT, "Brick Destroyer");
	}

	public static void main(String[] args) {
		new Game();
	}
}
