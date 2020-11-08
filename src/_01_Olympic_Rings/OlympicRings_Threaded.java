package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blue = new Robot(300, 100);
		Robot black = new Robot(500, 100);
		Robot red = new Robot(700, 100);
		Robot yellow = new Robot(400, 280);
		Robot green = new Robot(600, 280);
		
		blue.setSpeed(10);
		black.setSpeed(10);
		red.setSpeed(10);
		yellow.setSpeed(10);
		green.setSpeed(10);
		
		blue.penDown();
		blue.setPenColor(Color.BLUE);
		blue.setPenWidth(5);
		black.penDown();
		black.setPenColor(Color.BLACK);
		black.setPenWidth(5);
		red.penDown();
		red.setPenColor(Color.RED);
		red.setPenWidth(5);
		yellow.penDown();
		yellow.setPenColor(Color.YELLOW);
		yellow.setPenWidth(5);
		green.penDown();
		green.setPenColor(Color.GREEN);
		green.setPenWidth(5);
		
		Thread tI = new Thread(()->ring(blue));
		Thread tII = new Thread(()->ring(black));
		Thread tIII = new Thread(()->ring(red));
		Thread tIV = new Thread(()->ring(yellow));
		Thread tV = new Thread(()->ring(green));
		
		tI.start();
		tII.start();
		tIII.start();
		tIV.start();
		tV.start();
	}
	
	static void ring(Robot robot) {
		robot.setAngle(90);
		for (int i = 0; i < 360; i++) {
			robot.move(2);
			robot.turn(1);
		}
		robot.hide();
	}
}

