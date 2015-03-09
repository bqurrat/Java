/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int step = 0;
		int numb = 0;
		numb = readInt("Enter a number :");
		while (numb != 1) {
			if (numb % 2 != 0) {
				println(numb + " is odd, so I make 3n+1 : ");
				numb = (3 * numb) + 1;
			} else {
				println(numb + " is even, so I make n/2 :");
				numb = numb / 2;
			}
			++step;
		}
		println("");
		println("The process took " + step + " steps to reach 1");

	}
}
