package miscellaneous;

import java.util.Random;

public class OTP {

	public static void main(String[] args) {

		genOTP();
		genOTP_secondApproach();
		
	}
	
	public static void genOTP()
	{
		Random random = new Random(100000);
		int otp = random.nextInt(999999);
		System.out.println("OTP : "+otp);
	}
	
	public static void genOTP_secondApproach() 
	{
		Random random = new Random(); // Using random method

		String otpStr = "";
		for (int i = 0; i < 6; i++) {
			otpStr += random.nextInt(10);
		}
		int otp = Integer.parseInt(otpStr); 
		System.out.println("otp : "+otp);
	}

}
