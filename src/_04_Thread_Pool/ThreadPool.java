package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue;

	public ThreadPool(int num) {
		threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
		taskQueue = new ConcurrentLinkedQueue<Task>();
	}
	
	public void addTask(Task task) {
		taskQueue.add(task);
	}

	public void start() {
		for (Thread thread : threads) {
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
