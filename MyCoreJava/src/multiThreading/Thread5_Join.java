package multiThreading;

class BikeRegistration implements Runnable {
	@Override
	public void run() {
		System.out.println("Bike Registration Done !");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Medical implements Runnable {
	public Thread thMedical;

	public Medical(String thName) {
		this.thMedical = new Thread(this, thName); // setting "this" as the current runnable class instance
	}

	@Override
	public void run() {
		try {
			System.out.println("Medical Starts | Current thread = " + Thread.currentThread().getName());
			for (int i = 1; i <= 3; i++) {
				System.out.println("Medical test CONTINUING..");
				Thread.sleep(2000);
			}
			System.out.println("Medical Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Thread5_Join {

	public static void main(String[] args) throws InterruptedException {

		Thread thTestDrive = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Test Drive Starts | Current thread = " + Thread.currentThread().getName());
					for (int i = 1; i <= 3; i++) {
						System.out.println("Test Drive CONTINUING..");
						Thread.sleep(2000);
					}
					System.out.println("Test Drive Completed");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}, "thTestDrive");

		Thread thOfficerSign = new Thread(() -> {
			try {
				System.out.println("Officer takes the file | Current thread = " + Thread.currentThread().getName());
				for (int i = 1; i <= 3; i++) {
					System.out.println("Officer file checking CONTINUING..");
					Thread.sleep(2000);
				}
				System.out.println("Officer sign Completed.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}, "thOfficerSign");

		BikeRegistration bikeRegistration = new BikeRegistration();
		Thread thBikeReg = new Thread(bikeRegistration, "thBikeReg");
		thBikeReg.start();
		thBikeReg.join();

		Medical medical = new Medical("thMedical");
		medical.thMedical.start();
		medical.thMedical.join();

		thTestDrive.start();
		thTestDrive.join();

		thOfficerSign.start();
		thOfficerSign.join(); // We can also specify time in millisec here - jitne der ke liye aapko iss
								// thread ko control dena hai.

		System.out.println("Congratulations , Driving Licence issued Successfully !");

	}
}
