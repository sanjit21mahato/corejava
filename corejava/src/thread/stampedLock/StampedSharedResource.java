package thread.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedSharedResource {
	int a=10;
	StampedLock lock = new StampedLock();

	public void consumes() {
		long stamp = lock.tryOptimisticRead();
		try {
			System.out.println("Stamped acquired: " + Thread.currentThread().getName());
			a=11;
			Thread.sleep(5000);
			if (lock.validate(stamp)) {
				System.out.println("Updated value of a successfully: " + Thread.currentThread().getName());
			} else {
				System.out.println("Rollback");
				a = 10;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} /*finally {
			lock.unlock(stamp);
			System.out.println("Stamped releasing: " + Thread.currentThread().getName());
		}*/

	}

	public void produces() {
		long stamp=lock.writeLock();
		System.out.println("Write Lock Acquired: "+Thread.currentThread().getName());
		try{
			System.out.println("performing work");
			a=9;
		}finally {
			lock.unlockWrite(stamp);
			System.out.println("Write Lock Released: "+Thread.currentThread().getName());
		}
       
	}
	

}
