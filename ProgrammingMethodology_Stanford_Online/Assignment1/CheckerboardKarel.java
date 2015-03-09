/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	private int counter = 1;

	public void run() {
		putBeepereInRow();
		while (leftIsClear()) {
			repositionForWest();
			putBeepereInRow();
			if (rightIsClear()) {
				repositionForEast();
				putBeepereInRow();
			} else
				turnAround();
		}
		counter = 1;
	}

	// This Method will put the Beepers in a Row on alternate cells
	public void putBeepereInRow() {
		if (counter % 2 != 0) {
			putBeeper();
		}
		while (frontIsClear()) {
			move();
			++counter;
			if (counter % 2 != 0) { // check if counter is odd
				putBeeper();
			}
		}
	}

	// This method will reposition itself to move East direction
	public void repositionForEast() {
		turnRight();
		move();
		++counter;
		turnRight();
	}

	// This method will reposition itself to move West direction
	public void repositionForWest() {
		turnLeft();
		move();
		++counter;
		turnLeft();
	}
}