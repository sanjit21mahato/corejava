package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {

	public static void main(String[] args) {
	  SharedResource shared = new SharedResource();
	  Queue<Integer> queue =  new LinkedList<>();
      Thread t1= new Thread(()->{
    	  shared.produces(queue);
      });

      Thread t2= new Thread(()->{
    	  shared.consumes(queue);
      });
	}

}
