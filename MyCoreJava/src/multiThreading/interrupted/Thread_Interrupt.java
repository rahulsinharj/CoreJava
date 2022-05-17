package multiThreading.interrupted;

public class Thread_Interrupt implements Runnable {

	@Override
	public void run() {
//		System.out.println("A : "+Thread.interrupted());
		System.out.println("A : "+Thread.currentThread().isInterrupted());
		try {
			for(int i=1 ; i<=5 ; i++)
			{
				System.out.println(i);
				Thread.sleep(1000);
//				System.out.println("B : "+Thread.interrupted());
				System.out.println("B : "+Thread.currentThread().isInterrupted());
			}
			System.out.println("Thread is interrupted");
			
		} 
		catch (Exception e) {
			System.out.println("Thread interrupted : "+e);
		}
	}
	
	public static void main(String[] args) {
		
		Thread_Interrupt classObj = new Thread_Interrupt();
		Thread th = new Thread(classObj);
		th.start();
		th.interrupt();

		System.out.println("Thread interruption done !");
		
	}
}
