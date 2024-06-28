package thread;

public class ThreadImplements implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread using Runnable");
		System.out.println("Thread name: "+ Thread.currentThread().getName());
	}

}
