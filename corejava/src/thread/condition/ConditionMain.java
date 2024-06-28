package thread.condition;

public class ConditionMain {

	public static void main(String[] args) {

		ConditionSharedResource resource1 = new ConditionSharedResource();

		Thread t1 = new Thread(() -> {
			resource1.consumes();
		});

		Thread t2 = new Thread(() -> {
			resource1.produces();
		});

		t1.start();
		t2.start();
	}

}
