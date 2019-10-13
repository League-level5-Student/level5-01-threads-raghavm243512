package _02_Advanced_Robot_Race;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] r = new Robot[4];
		boolean finished = false;
		r[0] = new Robot(400, 700);
		r[1] = new Robot(800, 700);
		r[2] = new Robot(1200, 700);
		r[3] = new Robot(1600, 700);

		Thread t1 = new Thread(() -> {
			outLoop: while (!finished) {
				for (Robot robot : r) {
					if (robot.getY() <= 0) {
						break outLoop;
					}
				}
				r[0].move((int) (Math.random() * 10-3));
			}
		});
		Thread t2 = new Thread(() -> {
			outLoop: while (!finished) {
				for (Robot robot : r) {
					if (robot.getY() <= 0) {
						break outLoop;
					}
				}
				r[1].move((int) (Math.random() * 10-3));
			}
		});
		Thread t3 = new Thread(() -> {
			outLoop: while (!finished) {
				for (Robot robot : r) {
					if (robot.getY() <= 0) {
						break outLoop;
					}
				}
				r[2].move((int) (Math.random() * 10-3));
			}
		});
		Thread t4 = new Thread(() -> {
			outLoop: while (!finished) {
				for (Robot robot : r) {
					if (robot.getY() <= 0) {
						break outLoop;
					}
				}
				r[3].move((int) (Math.random() * 10-3));
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}
