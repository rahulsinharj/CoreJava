package multiThreading;

public class Thread4_Runnable_withLambda {

	public static void main(String[] args) throws InterruptedException {

		// Providing implementation Using Anonymous class , implementing all the methods of Runnable interface here inside.
		// Now since Runnable is functional interface(only single abstract method present in it), so we can also use Lambda expression here.
		Runnable obj1 = () -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("HiClass 	-- " + Thread.currentThread().getName() + "	 -- "
						+ Thread.currentThread().getPriority());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(obj1, "HiThread");

		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("HelloClass 	-- " + Thread.currentThread().getName() + "	 -- "
						+ Thread.currentThread().getPriority());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		t2.setName("HelloThread"); // Setting the name of the thread.
		System.out.println("t1 name : " + t1.getName());
		System.out.println("t2 name : " + t2.getName());

		// Also we can set the thread priority ourselves ::
//		t1.setPriority(Thread.MAX_PRIORITY);			// t1.setPriority(10);
//		t2.setPriority(Thread.MIN_PRIORITY);			// t2.setPriority(1);

		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());

		t1.start();
//		t1.join();

		t2.start();

		System.out.println("is T1 thread alive : " + t1.isAlive());

		t1.join(); 				// Matlab t1-thread ke liye main-thread ruko // Join will make your "main-thread" to wait for t1 & t2 thread to join again.
		t2.join(); 				// With this Line, we are telling our main-Thread to wait for t1,t2-thread to first complete its task and then only come to below main() method remaining code.

		Thread mainThread = Thread.currentThread(); 			// Getting main thread.
		System.out.println("MainThread : " + mainThread);

		System.out.println("is T2 thread alive : " + t2.isAlive());
		System.out.println("Current Thread : " + Thread.currentThread());
		System.out.println("Byee..!");
	}

}
