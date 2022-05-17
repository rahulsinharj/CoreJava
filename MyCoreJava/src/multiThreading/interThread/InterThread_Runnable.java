package multiThreading.interThread;		// Inter-Thread-Communication ::
/*
  	wait() and notifiy() belongs to Object class not Thread class, because wait() and notifiy() wants an object to work with. So they work with any object.
  		wait() on a Thread is done with the help of object, so that thread can wait for that object. Therefore these are Object methods. 
*/
class Company
{
	int num;
	boolean valueProduced = false;					// "valueAlreadyBeenProduced" flag 
	
	synchronized public void produce_Item(int num)	// here synchronized kiya hai -> taaki jab producer chale ispe to consumer na chal paye uss samay.
	{
		while(valueProduced)						// if "valueAlreadyBeenProduced" flag is coming as "true" (as set by PRODUCER/him only after him work completion) -> then PRODUCER will wait for the CONSUMER to consume first;
		{											// if "valueAlreadyBeenProduced" flag is coming as "false" -> matlab Value produced nhi hua hai abhi, PRODUCER no need to wait , it can produce;
			
			try { wait(); } catch (Exception e){e.printStackTrace();}			// With this line, we can ask the PRODUCER Thread to wait -> till CONSUMER Thread consumes the value.
		}
		System.out.println("Produced : " + num +" -- by " +Thread.currentThread().getName());		// Being Produced
		this.num = num;							
		valueProduced = true;						// false kar diya hai taaki CONSUMER ab consume kar sakta hai ab, matlab ki PRODUCER dwara produce kara ja chuka hai.
		notify();									// one thread will wait, the other thread will notify.
	}
	
	synchronized public void consume_Item()			// Whenever we use wait() method, then compulsory we have to use "synchronized" keyword in method. 			
	{	
		while(!valueProduced)						// if "valueNotBeenProduced" flag is coming as "true" (as set by CONSUMER/him only after him work completion) -> then CONSUMER will wait for the PRODUCER to produce first;
		{											// if "valueNotBeenProduced" flag is coming as "false" -> matlab value produced ho chuka hua hai, CONSUMER no need to wait , it can consume;
		
			try { wait(); } catch (Exception e){e.printStackTrace();}		// With this line, we can ask the CONSUMER Thread to wait -> till PRODUCER Thread produces the value.
		}
		System.out.println("Consumed : " + num +" -- by " +Thread.currentThread().getName());		// Being Consumed
		valueProduced = false;						// false kar diya hai taaki PRODUCER ab produce kar sakta hai ab, matlab ki CONSUMER dwara consume kara ja chuka hai.
		notify();
	}
}	

class Producer implements Runnable
{
	Company company;
	
	public Producer(Company company)
	{
		this.company = company ;
	}
	
	public void run() 
	{
		int i=0;
		while(true)
		{
			this.company.produce_Item(i++);
			try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace(); }
		}
	}
}

class Consumer implements Runnable
{
	Company company;
	
	public Consumer(Company company)
	{
		this.company = company ;
	}
	
	public void run() 
	{		
		while(true)
		{
			this.company.consume_Item();
			try { Thread.sleep(3000); } catch (Exception e) {e.printStackTrace(); }
		}
	}
}

public class InterThread_Runnable {

	public static void main(String[] args) {
		
		Company company = new Company();
		
		Thread thProducer = new Thread(new Producer(company), "Producer Thread");
		thProducer.start();
		
		Thread thConsumer = new Thread(new Consumer(company), "Consumer Thread");
		thConsumer.start();
		
	}

}
