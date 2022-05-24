package designPattern;

public class SingletonPattern_Demo {

	public static void main(String[] args) 
	{
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() 
			{
				MySingleton obj = MySingleton.getInstance();
				System.out.println("obj1 "+obj +" | Hashcode= "+obj.hashCode());
			}
		});
		
		Thread th2 = new Thread(() -> {
			MySingleton obj2 = MySingleton.getInstance();
			System.out.println("obj2 "+obj2 +" | Hashcode= "+obj2.hashCode());
		});
		
		th1.start();
		th2.start();
		
		MySingleton obj3 = MySingleton.getInstance();
		System.out.println("obj3 "+obj3 +" | Hashcode= "+obj3.hashCode());
		obj3.show();
		
	}
}

class MySingleton
{
//	static MySingleton obj = new MySingleton();		// 1. Eager type instance creation 
	static MySingleton obj;							// 2. Lazy type instance creation 
	
	private MySingleton() 
	{
		System.out.println("Instance Created !");
	}
	
/*#	Still we have problem with this , If we use 2 threads, one for MySingleton obj1 creation & other thread for MySingleton obj2 creation 
		In that case there is probability that both the thread might enter this getInstance() block at same time. And for both the thread the value of obj ref would be null. 
		Then both would get enter into if(obj == null) and for threads the statement "obj = new MySingleton();" will be executed twice. // That means we will be again getting 2 instance. 
  
  #	==> Solution :: One thread entering the method of getInstance() , then other thread must need to wait, untill first thread completion.	
	
  # But again, due to "Synchronized METHOD" it locks the entire getInstance() method , resulting in increase in thread waiting time for other parts of that methods (those part which have nothing to do with getInstance logic) unnecessarily.
 		Therefore better to use "Synchronized BLOCK" - which in intended to use on a certain part of program rather than the entire method (scope is lesser than the method) & boosts the performance of respective program.
*/	
//	public static synchronized MySingleton getInstance()	// 3. Synchronized METHOD instance creation 
	public static MySingleton getInstance()	
	{											
		if(obj == null) 
		{			
			synchronized (MySingleton.class) 				// 4. Synchronized BLOCK instance creation 
			{
				if(obj == null) 
					obj = new MySingleton();
			}
		}
		return obj;
	}
	
	public void show()
	{
		System.out.println("Inside MySingleton class show method");
	}
	
}
 