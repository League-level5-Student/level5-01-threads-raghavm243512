package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> tq;
	public Worker(ConcurrentLinkedQueue<Task> tasks) {
		tq=tasks;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!tq.isEmpty()) {
			tq.poll().perform();
		}
		
	}
	


}
