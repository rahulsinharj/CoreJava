package multiThreading.interThread;

//PC (Produce Consumer) class with produce() and consume() methods.
class MyMovieTheature 
{
	int totalEarning = 0 ;
	int numOfTickets;

	// Prints a string and waits for consume()
	public void watchMovie() throws InterruptedException 
	{
		// synchronized block ensures only one thread running at a time.
		synchronized (this) 
		{
			System.out.println("To watch movie, Please payment first ! Calling wait() method..");

			// releases the lock on shared resource
			wait();

			// and waits till some other method invokes notify().
			System.out.println("Congratulations, you can now watch movie on "+numOfTickets +" tickets !");
			
			System.out.println("Theature Total Earnings = Rs "+totalEarning);
		}
	}

	// Sleeps for some time and waits for a key press. After key is pressed, it notifies produce().
	public void paymentFirst(int tickets) throws InterruptedException 
	{
		// this makes the produce thread to run first.
		Thread.sleep(1000);
	
		// synchronized block ensures only one thread running at a time.
		synchronized (this) 
		{
			System.out.println("Payment processing has been started..");
			
			for(int i=1 ; i<=tickets; i++)
			{
				totalEarning += 100;
				this.numOfTickets += 1 ;
			}
			
			Thread.sleep(2000);
			System.out.println("Payment completion giving Notification ! Calling notify() method..");
			
			// notifies the WatchMovie thread that it can wake up.
			notify();

			// Sleep
			Thread.sleep(2000);
			
		}
	}
}

public class MyMoviePaymentApp 
{
	public static void main(String[] args) throws InterruptedException 
	{
		final MyMovieTheature theature = new MyMovieTheature();

		// Create a thread object that calls pc.produce()
		Thread thWatchMovie = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					theature.watchMovie();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} ,"thWatchMovie");

		// Create another thread object that calls pc.consume()
		Thread thPayment = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					theature.paymentFirst(11);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} ,"thPayment");

		// Start both threads
		thWatchMovie.start();
		thPayment.start();

		// t1 finishes before t2
		thWatchMovie.join();
		thPayment.join();
	}

}
