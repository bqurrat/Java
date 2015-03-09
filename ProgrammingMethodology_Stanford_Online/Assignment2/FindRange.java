/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public static final int SENTINEL = 0;

	public void run() {
		int new_num;
		int my_max = Integer.MIN_VALUE;   // try not to use 'max' and 'min' as variable names
		int my_min = Integer.MAX_VALUE;
		int ctr = 0;
		
		while (true) {
			new_num = readInt("? ");
			if (new_num == SENTINEL)
				break;
			
			if (new_num > my_max) {
				my_max = new_num;
			}
			// my_max = Math.max(new_num, my_max);
			
			if (new_num < my_min) {
				my_min = new_num;
			}
			// my_min = Math.min(new_num, my_min);
			++ctr;
		}
		
		if (ctr == 0) {
			println ("No value has been entered") ;
		} else {
			println("Max is : " + my_max);
			println("Min is : " + my_min);
		}
	}
}
