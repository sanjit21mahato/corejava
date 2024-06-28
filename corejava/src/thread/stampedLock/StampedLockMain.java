package thread.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockMain {

	public static void main(String[] args) {

		StampedSharedResource resource1 = new StampedSharedResource();
		//StampedLock lock = new StampedLock();
		
	     Thread t1 = new Thread(()->{
	    	 resource1.consumes();
	     });
	     
	     Thread t3 = new Thread(()->{
	    	 resource1.produces();
	     });
	     
	     t1.start();
	     t3.start();

	}

}
