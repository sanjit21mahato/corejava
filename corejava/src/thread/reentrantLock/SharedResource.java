package thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
	boolean isAvailable=false;
	
	
	public void producer(ReentrantLock lock){
		
		lock.lock();
		System.out.println("Lock acquired by: "+Thread.currentThread().getName());
		try {
			isAvailable= true;
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			lock.unlock();
			System.out.println("Lock releases by:"+ Thread.currentThread().getName());
		}
		
	}
	

}
