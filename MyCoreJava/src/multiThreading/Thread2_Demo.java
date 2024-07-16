package multiThreading;

class Hi extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Hello extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class Thread2_Demo {

	public static void main(String[] args) {

		Hi hiObj = new Hi();
		Hello hlObj = new Hello();

		hiObj.start();

		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}

		hlObj.start();

	}
}
