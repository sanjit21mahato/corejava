package thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

	public static void main(String[] args) {
		
		SharedResource resource1 = new SharedResource();
		SharedResource resource2 = new SharedResource();
		
		ReentrantLock lock = new ReentrantLock();
		
		Thread t1 = new Thread(()->{
			resource1.producer(lock);
		});
		
		Thread t2 = new Thread(()->{
			resource2.producer(lock);
		});
		
		t1.start();
		t2.start();
		

	}

}
