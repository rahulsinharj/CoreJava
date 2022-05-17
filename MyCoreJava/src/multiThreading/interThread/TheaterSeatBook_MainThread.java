package multiThreading.interThread;

class CalculateEarning extends Thread {
	
	int totalEarning = 0 ;
	int numOfTickets;
	
	public CalculateEarning(int numOfTickets) {
		super();
		this.numOfTickets = numOfTickets;
	}

	@Override
	public void run() 
	{
		synchronized(this) 
		{
			try {
				Thread.sleep(1000);
				System.out.println("Earning calculation starts..");
				for(int i=1 ; i<=numOfTickets; i++)
				{
					totalEarning = totalEarning + 100;
				}
				Thread.sleep(2000);
				System.out.println("Earning completion giving Notification !");
				this.notify();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TheaterSeatBook_MainThread {

	public static void main(String[] args) throws InterruptedException {
		
		CalculateEarning th = new CalculateEarning(11);
		th.start();
		
		synchronized(th) 
		{
			System.out.println("MainMethod calling wait() method..");
			th.wait();
			System.out.println("MainMethod got Notification !");
			Thread.sleep(2000);
			System.out.println("Theature Total Earnings = Rs "+th.totalEarning);
		}
						
	}
}