package thread.semaphoreLock;

import java.util.concurrent.Semaphore;

public class SemaphoreSharedResource {
	boolean isAvaialable=false;
	
	Semaphore lock = new Semaphore(2);

	public void consumes(){
		try {
			lock.acquire();
			System.out.println("Acquiring Semaphore Lock:"+ Thread.currentThread().getName());
			Thread.sleep(4000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			lock.release();
			System.out.println("Releasing Semaphore lock:" + Thread.currentThread().getName());
		}
		
	}
}
