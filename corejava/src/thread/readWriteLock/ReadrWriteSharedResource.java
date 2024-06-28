package thread.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadrWriteSharedResource {
	boolean isAvailable = false;

	public void consumes(ReadWriteLock lock) {
      lock.readLock().lock();
      System.out.println("Reading: "+isAvailable);
      System.out.println("Read Loack Acquired:"+ Thread.currentThread().getName());
      try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}finally{
      lock.readLock().unlock();
	  System.out.println("Read Loack Release:" + Thread.currentThread().getName());
	}
	}

	public void produces(ReadWriteLock lock) {
		lock.writeLock().lock();
		 try {
				Thread.sleep(3000);
		 }catch(Exception e){
			 
		 }finally{
		System.out.println("Write Lock Acquired:"+ Thread.currentThread().getName());
		lock.writeLock().unlock();
		 }
	}

	

	
}
