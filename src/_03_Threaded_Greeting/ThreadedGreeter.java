package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int threadnum;
	
	public ThreadedGreeter(int threadnum) {
		this.threadnum = threadnum;
	}

	@Override
	public void run() {
		System.out.println("Hello from thread number: " + threadnum);
		if (threadnum <= 50) {
			Thread thread = new Thread(new ThreadedGreeter(threadnum + 1));
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
