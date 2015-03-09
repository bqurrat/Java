/*

 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		double x=getWidth();
		x=(x/2)-72;
		double y=getHeight();
		y=(y/2)-72;
		GOval oval1 = new GOval (x,y,144,144);
		oval1.setColor(Color.BLACK);
		oval1.setFilled(true);
		oval1.setFillColor(Color.RED);
		
		double a=getWidth();
		a=(a/2)-46.8;
		double b=getHeight();
		b=(b/2)-46.8;
		GOval oval2 = new GOval (a,b,93.6,93.6);
		oval2.setColor(Color.BLACK);
		oval2.setFilled(true);
		oval2.setFillColor(Color.WHITE);
		
		double c=getWidth();
		c=(c/2)-21.6;
		double d=getHeight();
		d=(d/2)-21.6;
		GOval oval3 = new GOval (c,d,43.2,43.2);
		oval3.setColor(Color.BLACK);
		oval3.setFilled(true);
		oval3.setFillColor(Color.RED);

		
		add(oval1);
		add(oval2);
		add(oval3);
		
		/* You fill this in. */
	}
}
