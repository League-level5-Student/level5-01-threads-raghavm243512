package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread t[];
	ConcurrentLinkedQueue<Task> tasks;
	public ThreadPool(int i) {
		// TODO Auto-generated constructor stub
		t = new Thread[i];
		tasks = new ConcurrentLinkedQueue<Task>();
		for (int j=0;j<t.length;j++) {
			t[j] = new Thread(new Worker(tasks));
		}
		
		
	}
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		tasks.add(task);
		
	}
	public void start() {
		// TODO Auto-generated method stub
		for (Thread th : t) {
			th.start();
		}
		
	}


}
