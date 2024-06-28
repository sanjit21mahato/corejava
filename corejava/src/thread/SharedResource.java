package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;

public class SharedResource {
 
    
	public synchronized void produces(Queue<Integer> queue) {

		while(queue.size()==10){
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	  queue.add(1);
       notifyAll();
		
	}

	public synchronized void consumes(Queue<Integer> queue) {

     while(queue.isEmpty()){
    	 try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
		queue.poll();
	}

}
