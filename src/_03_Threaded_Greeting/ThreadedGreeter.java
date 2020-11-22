package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int threadnum;
	
	public ThreadedGreeter(int threadnum) {
		this.threadnum = threadnum;
	}

	@Override
	public void run() {
		System.out.println("Hello from thread number: " + threadnum);
	}	
}
