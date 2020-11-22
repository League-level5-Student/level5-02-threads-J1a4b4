package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.*;;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static Robot[] robots = new Robot[5];
	static Random random = new Random();
	static boolean end = false;
	
	public static void main(String[] args) {
		int xVal = 100;
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
			robots[i].setSpeed(75);
			robots[i].setX(xVal);
			robots[i].setY(590);
			xVal += 100;
		}
		Thread i = new Thread(() -> {
			while (!end) {
				moveRobot(robots[0]);
			}
		});
		Thread ii = new Thread(() -> {
			while (!end) {
				moveRobot(robots[1]);
			}
		});
		Thread iii = new Thread(() -> {
			while (!end) {
				moveRobot(robots[2]);
			}
		});
		Thread iv = new Thread(() -> {
			while (!end) {
				moveRobot(robots[3]);
			}
		});
		Thread v = new Thread(() -> {
			while (!end) {
				moveRobot(robots[4]);
			}
		});
		i.start();
		ii.start();
		iii.start();
		iv.start();
		v.start();
	}
	
	public static void moveRobot(Robot r) {
		r.move(random.nextInt(50));
		if (r.getY() <= 0) {
			end = true;
		}
	}
}