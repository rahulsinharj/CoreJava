package multiThreading.interThread;

class TheatureBooker
{
	int totalPayment = 0 ;
	int numOfTickets;
	
	boolean flag = false;
	
	synchronized void watchMovie() 
	{
		try {
//			if(!flag) {
//				System.out.println("Please payment first !");
//				this.wait();
//			}
			System.out.println("To watch movie, Please payment first ! Calling wait() method..");
			wait();
			
			Thread.sleep(1200);
			System.out.println("Congratulations, you can watch movie on "+numOfTickets +" tickets");
			System.out.println("Theature Total Payment = Rs "+totalPayment);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	synchronized void bookTicket(int numOfTickets) throws InterruptedException 
	{
		Thread.sleep(2000);
		System.out.println("Payment processing has been started..");
		
		for(int i=1 ; i<=numOfTickets; i++)
		{
			totalPayment += 100;
			this.numOfTickets += 1;
			System.out.println("Payment is processing.. | LoadingPayment : "+totalPayment);
			Thread.sleep(1000);
		}
//		flag = true; 
		this.notify();
		
	}
}

class WatchMovie implements Runnable
{
	TheatureBooker theature;
	
	public WatchMovie(TheatureBooker theature)
	{
		this.theature = theature ;
	}
	
	public void run() 
	{		
		this.theature.watchMovie();
	}
}

class PaymentFirst implements Runnable
{
	TheatureBooker theature;
	int numOfTickets ; 
	public PaymentFirst(TheatureBooker theature, int numOfTickets)
	{
		this.theature = theature ;
		this.numOfTickets = numOfTickets;
	}
	
	public void run() 
	{
		try {
			this.theature.bookTicket(numOfTickets);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class MyMoviePaymentApp_RunnableThreads {

	public static void main(String[] args) throws InterruptedException {
	
		TheatureBooker theature = new TheatureBooker();
		
		Thread thWatchMovie = new Thread(new WatchMovie(theature), "WatchMovie Thread");
		Thread thPaymentFirst = new Thread(new PaymentFirst(theature, 11), "PaymentFirst Thread");
		
		thWatchMovie.start();
		thPaymentFirst.start();

		thWatchMovie.join();
		thPaymentFirst.join();

	}

}
