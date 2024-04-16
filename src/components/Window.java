package components;

/**
 * This class displays the window and the game.
 * 
 * @author Rithvik Muthyalapati and Atharv Koratkar
 * @version Final
 */

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Window {

	/**
	 * The constructor for the Window class.
	 * 
	 * @param w     The width of the window pane.
	 * @param h     The height of the window pane.
	 * @param title The title displayed on the border of the window pane.
	 */
	public Window(int w, int h, String title) {
		JFrame frame = new JFrame(title);

		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		surf.setTitle(title);

		frame = (JFrame) canvas.getFrame();
		frame.setPreferredSize(new Dimension(w, h));
		frame.setMaximumSize(new Dimension(w, h));
		frame.setMinimumSize(new Dimension(w, h));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
