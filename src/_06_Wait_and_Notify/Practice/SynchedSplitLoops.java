package _06_Wait_and_Notify.Practice;

/*
 
Below are two threads. One thread increments the counter
and the other thread prints the result. If you run the
program as it is, you'll notice that the output is not
sequential.

Your goal is to modify the code inside the threads so that 
they are in synch. Use synchronized, wait, and notify to make
it so that t1 will only increase counter after t2 has printed 
the previous result. The output should be the numbers 0 to 100000
printed in order.
  
*/

public class SynchedSplitLoops {
	static int counter = 0;
	static Object lock = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				for (int i = 0; i < 100001; i++) {
					counter++;
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("error");
					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				for (int i = 0; i < 100001; i++) {
					System.out.println(counter);
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("error");
					}
				}
			}
		});

		t2.start();
		t1.start();

		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			System.err.println("Could not join threads");
		}

	}
}
