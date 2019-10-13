package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	static int[] cx = new int[4];
	static int cy = 700;

	public static void main(String[] args) {
		Robot[] r = new Robot[4];
		r[0] = new Robot(400, 700);
		r[1] = new Robot(800, 700);
		r[2] = new Robot(1200, 700);
		r[3] = new Robot(1600, 700);
		for (int i = 0; i < 4; i++)
			cx[i] = r[i].getX() - 200;

		Thread t1 = new Thread(() -> {
			while (true)
				circle(r, 0);
		});
		Thread t2 = new Thread(() -> {
			while (true)
				circle(r, 1);
		});
		Thread t3 = new Thread(() -> {
			while (true)
				circle(r, 2);
		});
		Thread t4 = new Thread(() -> {
			while (true)
				circle(r, 3);
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

	public static void circle(Robot[] r, int index) {
		double theta = Math.atan2(r[index].getY() - cy, r[index].getX() - cx[index]);
		theta += 0.01;
		r[index].moveTo((int) (cx[index] + 200 * Math.cos(theta)), (int) (cy + 200 * Math.sin(theta)));
		r[index].setAngle((int) (Math.toDegrees(theta)));
	}

}
