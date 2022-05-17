package multiThreading.daemonThread;

public class DaemonThreadTest extends Thread 
{
	@Override
	public void run() 
	{
		if (Thread.currentThread().isDaemon()) 
		{
			System.out.println("Daemon Thread");
		} 
		else 
		{
			System.out.println("Normal Thread");
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("**Main Thread**");
		
		DaemonThreadTest t = new DaemonThreadTest();
		t.setDaemon(true);				// If we make thread 't' as daemon then "Thread.currentThread().isDaemon()" will give TRUE     
		t.start();
			
	}
}
