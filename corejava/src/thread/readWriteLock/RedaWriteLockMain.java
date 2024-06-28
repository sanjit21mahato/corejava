package thread.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedaWriteLockMain {

	public static void main(String[] args) {


		ReadrWriteSharedResource sharedResource1 = new ReadrWriteSharedResource();
		ReadrWriteSharedResource sharedResource2 = new ReadrWriteSharedResource();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		Thread t1 = new Thread(()->{
			sharedResource1.consumes(lock);
		});
		
		Thread t2 = new Thread(()->{
			sharedResource1.consumes(lock);
		});
		
		Thread t3 = new Thread(()->{
			sharedResource2.produces(lock);
		});

		t1.start();
		t2.start();
		t3.start();
	}

}
