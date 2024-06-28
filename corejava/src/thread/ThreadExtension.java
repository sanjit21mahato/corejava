package thread;

public class ThreadExtension extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread Extension");
		System.out.println("Thread name: "+ Thread.currentThread().getName());
	}

}
