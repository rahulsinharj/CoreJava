package multiThreading.interThread;

class Customer {
	int currentAmount = 1000;

	synchronized void withdraw(int requestedAmount) 
	{
		System.out.println("Going to withdraw Rs "+requestedAmount);

		if (this.currentAmount < requestedAmount) 
		{
			System.out.println("Sorry Less balance ! Only Rs "+currentAmount +" is left ; Waiting for deposit...");
			try {
				wait();
			} 
			catch (Exception e) {
			}
		}
		this.currentAmount -= requestedAmount;
		System.out.println("Rs "+requestedAmount +" withdraw completed ! Current Balance = Rs "+currentAmount);
	}

	synchronized void deposit(int depositedAmount) 
	{
		System.out.println("Going to deposit Rs "+depositedAmount);
		this.currentAmount += depositedAmount;
		System.out.println("Deposit completed ! Current Balance = Rs "+currentAmount);
		notify();
	}
}

public class InterThread_WithdrawDeposit {

	public static void main(String[] args) 
	{
		final Customer c = new Customer();

		Thread thWithdraw = new Thread(() -> {
			c.withdraw(1500);
		});
		thWithdraw.start();

		Thread thDeposit = new Thread(new Runnable() {
			public void run() {
				c.deposit(1000);
			}
		});
		thDeposit.start();
		
		
/*		// Thread creation using Anonymous Inner class ::
  
  		Thread thDeposit = new Thread() {
			public void run() {
				c.deposit(10000);
			}
		};
		thDeposit.start();
*/
		
/*		// This below approach is not possible at all - since Thread class is not a functional interface, but Runnable interface is.	
  
  		Thread thDeposit = () -> 
  		{
			c.deposit(10000);
		};
  	
  		
  
  		
*/
		
		
	}
}
