package demo;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class PasswordSecure_using_JavaBase64 {

	public static void main(String[] args) 
	{
		String originalString = "Rahul@1234";
		
		Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(originalString.getBytes());
		System.out.println("Encrypted Value :: " + encodedString);

		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encodedString);
		System.out.println("Decrypted Value :: " + new String(bytes));
		
		
		
	}
}
