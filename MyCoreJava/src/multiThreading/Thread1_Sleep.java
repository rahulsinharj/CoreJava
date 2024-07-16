package multiThreading;

class HiClass {

	public void show() {
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

class HelloClass {

	public void show() {
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

public class Thread1_Sleep {

	public static void main(String[] args) {

		HiClass hiObj = new HiClass();
		HelloClass hlObj = new HelloClass();
		hiObj.show();
		hlObj.show();

	}
}
