package multiThreading.synchronization;			// SYNCHRONIZED means only Thread can use that at a time.

class Counter {
	int count;

	public synchronized void increment() 		// Added with "synchronized" keyword to make method as thread-safe => i.e, one thread at a particular time  
 	{	
		count++;
	}
}

public class ThreadSyncDemo {

	public static void main(String[] args) throws Exception {

		Counter c = new Counter();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}
		);

		t1.start();
		t2.start();
		
		t1.join();								 	// We have to ask the main-thread to wait for the t1-thread to complete its job.
		t2.join();									// t1,t2 pe join() lagane se ab main() method ka ye niche ka code t1,t2 thread ke khatam hone tak ka wait karega, only tabhi fir main-thread aage execute hoga - aur sop count print karega.   
		System.out.println("Count : " + c.count); 	// By the time t1-thread is busy incrementing this , the main-thread is doing nothing and id printing count as it is.

	/*	# THREAD-UNSAFE senario : When multiple threads can access the same method at the same time.
	  	Sometime it can happen that both t1-thread & t2-thread are fetching any incrementing the value at same time. (This senario is happening multiple times)                  
		 	That means both the threads are using the increment method as same exact time - that is the issue
			
		What we want is - When t1-thread is executing the increment method, t2-thread should not execute this.
			Same if t2-thread is executing this method, t1-thread should not interfere for that particular milisec.
			
		# THREAD-SAFE senario : When single thread can access a method at a time, other thread will not interfere.
			That is we want only ONE-thread to work with this method at a particular time(milisec) => make the increment() method as "synchronized"	
	
	*/

	
	}

}
