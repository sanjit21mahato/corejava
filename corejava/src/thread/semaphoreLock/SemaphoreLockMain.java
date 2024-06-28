package thread.semaphoreLock;

public class SemaphoreLockMain {
	
 
	public static void main(String[] args) {

		SemaphoreSharedResource resource1 = new SemaphoreSharedResource();
		 
		Thread t1= new Thread(()->{
			resource1.consumes();
		});
		Thread t2= new Thread(()->{
			resource1.consumes();
		});
		Thread t3= new Thread(()->{
			resource1.consumes();
		});
		Thread t4= new Thread(()->{
			resource1.consumes();
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
