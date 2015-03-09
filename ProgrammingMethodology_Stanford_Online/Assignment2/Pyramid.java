/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 25;

	public void run() {
		
		
		double sp1 = getWidth();
		sp1 = ( sp1 - BRICKS_IN_BASE * BRICK_WIDTH ) / 2;
		double h = getHeight();
		h = h - BRICK_HEIGHT;
		
		for (int j = BRICKS_IN_BASE; j > 0; j--) {
			double sp2 = sp1;
			for (int i = 0; i < j; i++) {
				GRect brick1 = new GRect(sp2, h, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick1);
				sp2 = sp2 + BRICK_WIDTH;
			}
			h = h - BRICK_HEIGHT;
			sp1 = sp1 + BRICK_WIDTH / 2;
		}
	}
}
