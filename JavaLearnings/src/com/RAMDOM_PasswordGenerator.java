package com;

import java.util.Random;

public class RAMDOM_PasswordGenerator {

	public static void main(String[] args)
    {
        // Length of your password as I have choose here to be 8
        int len = 10;
        System.out.println("Your new password is : " + gen_Password(len));
        System.out.println("Your LowerCase pwd is : " +gen_lowercase_pwd(len));
    }
  
    // This our Password generating method. We have use static here, so that we not to make any object for it
    static String gen_Password(int len)
    {
      	// A strong password has Cap_chars, Lower_chars, numeric value and symbols. So we are using all of them to generate our password
        String allowedStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        Random random = new Random();   // Using random method
  
//      char[] password = new char[len];
        String pass = "";
        
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value. Use of nextInt() as it is scanning the value as int
        	
//           password[i] = allowedStr.charAt(random.nextInt(allowedStr.length()));
        	 pass += allowedStr.charAt(random.nextInt(allowedStr.length()));
/*            								------------------------------------
            								 matlab next int Lao 0 se 62 tak ke bich ka koi random number.
            			  -------------------------------------------------------
            			   matlab allowedStr ke charAt(random 0 to 62), koi sa bhi character aa skta hai Randomly.					
*/            							
        }
        return pass;
//     	return String.valueOf(password);		// Converting char[] to String
    }
    
    static String gen_lowercase_pwd(int len)
    {
    	StringBuilder sb = new StringBuilder(len);
		for(int i=0; i<len ; i++)
		{
			sb.append((char)(Math.floor(Math.random()*26) + 97));	
			
			/* Matlab ki random me 0.33 ya 0.25 aise values aayege ; jisko ki 26 se multiply karne pe 0.00 se 25.99 tak koi sa bhi value aayega 
			  	-> uska floor integral value 0 se 25 tak aaapko value dega.
			  	-> usko +97 karke start point 97 hojayega, aur range to 0to26 hai hi. => uss ascii ka bas char value nikal lo.
			*/
		}
    	
    	return sb.toString();
    }
}
