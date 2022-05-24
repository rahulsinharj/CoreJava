package designPattern;

public class SingletonPattern_Demo {		// Creates 1 object - per JVM

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
{																																																																			 // {Agar ise use naa bhi kare to bhi memory me load hoga hi, kyuki ye static hai} 	
//	private static MySingleton obj = new MySingleton();		// 1. Eager type instantiation [it will be created, even if you are not using it] :: The drawback here is - since this obj is static, therefore this static object will be created on compile time only, and it will be in memory when the class is loaded, and it becomes a global variable. Hence even if you don't use it, it will still be there in memory.   
	
	private static MySingleton obj;							// 2. Lazy type instantiation (instance creation) [it will NOT be created, even if you are not using it] :: We can make it lazy by creating the instance at the time of calling the getInstance() method. 
	
	private MySingleton() 
	{
		System.out.println("Instance Created !");
	}
	
/*#	Still we have problem with this , If we use 2 threads, one for MySingleton obj1 creation & other thread for MySingleton obj2 creation 
		In that case there is probability that both the thread might enter this getInstance() block at same time. And for both the thread the value of obj ref would be null. 
		Then both would get enter into if(obj == null) and for threads the statement "obj = new MySingleton();" will be executed twice. // That means we will be again getting 2 instance. 
  
 # ==> Solution = Synchronized method :: One thread entering the method of getInstance() , then other thread must need to wait, untill first thread completion.	
	
 # But again, due to "Synchronized METHOD" it locks the entire getInstance() method , resulting in increase in thread waiting time for other parts of that methods (those part which have nothing to do with getInstance logic) unnecessarily.
 		Therefore better to use "Synchronized BLOCK" - which in intended to use on a certain part of program rather than the entire method (scope is lesser than the method) & boosts the performance of respective program.
 
 # Double checking for NULL -> because let's say there are 2 threads T1 & T2. And let's T1 & T2  both thread both passes first_IF_check_condition and enter into it.
 			And then due to synchronized block only one thread (let's say T1 thread) enters into synchronized block and T2 thread wait for till it's completion.
 			Since T1 thread is already ==NULL , therefore it will create a new INSTANCE OBJECT.
 			And now, T2 thread will get a chance to come inside synchronized block => kayade se ab synchronized block me aa to gaya hai T2 thread, but T1 thread ke karan already 1 INSTANCE obj bana ja chuka hai, to ab aur koi new INSTANCE obj nhi banne dena chahiye, bhale hi synchronized block me enter hogya ho T2 ka control flow.
 			Therefore, again we will check ki bich kuch time me obj ref me INSTANCE obj to nhi aagya n, isliye fir se null check rahe hai even inside synchronized block. 
 						
*/	
//	public static synchronized MySingleton getInstance()	// 3. Synchronized METHOD instance creation 
	public static MySingleton getInstance()	
	{											
		if(obj == null) 
		{			
			synchronized (MySingleton.class) 				// 4. Synchronized BLOCK instance creation 
			{
				if(obj == null)								// Double checking for NULL 
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
 