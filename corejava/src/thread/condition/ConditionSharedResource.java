package thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSharedResource {

	boolean isItemAvailable = false;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void produces() {
		try {
			lock.lock();
			System.out.println("Produce Lock acquired by:" + Thread.currentThread().getName());
			// already available thread has to wait for consumer to consume
			if (isItemAvailable) {
				System.out.println("Produce Thread is waiting:" + Thread.currentThread().getName());
				condition.await();
			} 
			isItemAvailable = true;
			// condition.signal();
			condition.signalAll();
			System.out.println("Producer Signalling");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Producer Lock released");
		}

	}

	public void consumes() {

		try {
			lock.lock();
			Thread.sleep(4000);
			System.out.println("Consume Lock acquired by:" + Thread.currentThread().getName());
			if (!isItemAvailable) {
				// thread has to wait for it to produced
				System.out.println("Consume Thread is waiting:" + Thread.currentThread().getName());
				condition.await();
			}
			isItemAvailable = false;
			condition.signalAll();
			System.out.println("Consumer Signalling");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Consumer Lock released");
		}

	}

}
