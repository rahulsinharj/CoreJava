package multiThreading;

class A {
}

//	When already inhering some other class, then implementing run() method can only be used by implementing Runnable Interface
class Hii extends A implements Runnable {
	
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hi");
			System.out.println("Current Thread : " + Thread.currentThread().getName());
//			try { Thread.sleep(500); } catch (Exception e) {e.printStackTrace(); }
			System.out.println(
					Thread.currentThread().getName() + " isAlive status : " + Thread.currentThread().isAlive());
		}
	}
}

//	We can do call run() even even this class extends "Thread" class. Then why implementing Runnable interface ?
//	This is because if there is some other class which has been already inherited by this class then, in that case extending Thread won't be possible.
class Helloo implements Runnable {
	
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			System.out.println("Current Thread : " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(
					Thread.currentThread().getName() + " isAlive status : " + Thread.currentThread().isAlive());
		}
	}
}

public class Thread3_RunnableDemo {

	public static void main(String[] args) {

		Runnable hiObj = new Hii(); 		// We can also write here => Hii hiObj = new Hii(); // because parent ref can hold child obj
		Runnable hlObj = new Helloo(); 		// We can also write here => Helloo hlObj = new Hii();

		Thread th1 = new Thread(hiObj); 	// Without giving 'HiObj' to 'Thread' obj constructor, 't1' will call run() method of its own Thread class.
		Thread th2 = new Thread(hlObj); 	// Linking Hi/Hello obj with Thread - // Constructor of Thread class ask for Runnable obj.

		th1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}

		th2.start();
		System.out.println("Current Thread : " + Thread.currentThread());

		// Creating Thread using Anonymous class :
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Current Thread : " + Thread.currentThread().getName());
			}
		});

		th3.setName("MyAnnonymousClassThread3");
		th3.start();
		System.out.println(
				Thread.currentThread().getName() + "-thread isAlive-status : " + Thread.currentThread().isAlive());
		System.out.println(th1.getName() + " isAlive-status : " + th1.isAlive());
		System.out.println(th2.getName() + " isAlive-status : " + th2.isAlive());
		System.out.println(th3.getName() + " isAlive-status : " + th3.isAlive());

	}
}
