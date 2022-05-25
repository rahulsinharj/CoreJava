package designPattern;

public class SingletonPattern_InnerClass {

	public static void main(String[] args) {

		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				SingletonS obj = SingletonS.getInstance();
				System.out.println("obj1 " + obj + " | Hashcode= " + obj.hashCode());
			}
		});

		Thread th2 = new Thread(() -> {
			SingletonS obj2 = SingletonS.getInstance();
			System.out.println("obj2 " + obj2 + " | Hashcode= " + obj2.hashCode());
		});

		th1.start();
		th2.start();

		SingletonS obj3 = SingletonS.getInstance();
		System.out.println("obj3 "+obj3 +" | Hashcode= "+obj3.hashCode());
		
	}
}

class SingletonS 
{
	private SingletonS() {
		System.out.println("Instance Created !");
	}

	// Inner class to provide instance of class
	private static class BillPughSingleton 
	{
		private static final SingletonS obj = new SingletonS();
	}

	public static SingletonS getInstance() 
	{
		return BillPughSingleton.obj;
	}
}
