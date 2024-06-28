package thread;

public class ThreadCreations {

	public static void main(String[] args) {

        System.out.println("Thread name:"+ Thread.currentThread().getName());
        
		ThreadExtension t1 = new ThreadExtension();
		t1.start();
		
		Thread t2 = new Thread(new ThreadImplements());
		t2.start();
		
		Thread t3 = new Thread(()->{
			System.out.println("Uisng lambda");
			System.out.println("Thread name: "+ Thread.currentThread().getName());
		});
		t3.start();
		

	}

}
