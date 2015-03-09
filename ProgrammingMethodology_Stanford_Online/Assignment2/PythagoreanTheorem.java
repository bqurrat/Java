/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		System.out.println("Enter values to compute Pythagorean Theorem");
		
		int n1 = readInt ("a: ");
		int n2 = readInt ("b: ");
		
		double c = Pytho(n1, n2);
		
		System.out.println("The total is :" + c);
		
	}
	
	public double Pytho(int x, int y) {
		return Math.sqrt(x * x + y * y);
	}
}
