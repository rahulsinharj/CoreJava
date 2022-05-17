package miscellaneous;

import java.util.Calendar;
import java.util.logging.*;

public class MyLogger {

	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);   
	
	public static void main(String[] args) {

		int [] arr = {1 , 2 , 0, 7, 2 , 0 , 2, 2};
		
		LOGGER.log(Level.INFO, "Welcome !"); 
//		LOGGER.severe("severe");
//		LOGGER.info("info");
//		LOGGER.log(Level.WARNING, "INFO");
//		SEVERE(HIGHEST LEVEL)
//		WARNING
//		INFO
//		CONFIG
//		FINE
//		FINER
//		FINEST(LOWEST LEVEL)
//		System.out.println(" : "+Arrays.toString(arr));
//		System.out.println(find(arr, arr.length));
		
//		Scanner kb = new Scanner(System.in);
//		int a = kb.nextInt();
		
		System.out.println(Calendar.getInstance().getTime());
		
		  LOGGER.info("**Scheduled start time for the task : " + "a");
	      LOGGER.info("**Current time of the day		  : " + "b");
	}

	
}