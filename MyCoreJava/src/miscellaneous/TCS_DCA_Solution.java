package miscellaneous;

import java.util.Scanner;

class Bank {
	
	private int bankid;
	private String bankName;
	private int numberOfCustomers;
	private String city;
	
	public Bank() {
		super();
		
	}
	
	public Bank(int bankid, String bankName, int numberOfCustomers, String city) {
		super();
		this.bankid = bankid;
		this.bankName = bankName;
		this.numberOfCustomers = numberOfCustomers;
		this.city = city;
	}
	
	public int getBankid() {
		return bankid;
	}
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}

public class TCS_DCA_Solution {

	public static void main(String[] args) {

		Scanner kb =new Scanner(System.in);
		Bank[] banks = new Bank[4];
		for(int i=0; i<4; i++)
		{
			int bankid = kb.nextInt();
			String bankName = kb.next();
			int numberOfCustomers = kb.nextInt();
			String city = kb.next();
			banks[i] = new Bank(bankid,bankName,numberOfCustomers,city);
		}
		String findCity = kb.next();
		int avgCust = findAvgNumberOfCustomersByCity(banks , findCity);
		if(avgCust>0)
			System.out.println(avgCust);
		else {
			System.out.println("Bank not found");
		}
		
		
		Bank b = getSecondLowerNumberOfCustomersBank(banks);
		if(b==null)
		{
			System.out.println("Bank not found");
		}
		else {
			System.out.println(b.getBankid());
			System.out.println(b.getBankName());
			System.out.println(b.getNumberOfCustomers());
			System.out.println(b.getCity());
		}
		
	}
	
	public static int findAvgNumberOfCustomersByCity(Bank[] banks , String city)
	{
		boolean havingCity = false;
		int avgNumOfCust = 0 ;
		int avgCount=0;
		for(int i=0; i<banks.length; i++)
		{
			
			if(banks[i].getCity().equalsIgnoreCase(city))
			{
				avgCount++; 
				havingCity = true;
				avgNumOfCust+= banks[i].getNumberOfCustomers();
			}
			
		
		}
		avgNumOfCust /= avgCount;
		
		if(havingCity == true)
			return avgNumOfCust;
		else
			return 0;
		
	}
	
	public static Bank getSecondLowerNumberOfCustomersBank(Bank[] banks)
	{
		boolean havingEvenNumCust = false;
		int first, second, i;
		first = second = Integer.MAX_VALUE;
		for(i=0; i<banks.length; i++)
		{
			int numOfCust= banks[i].getNumberOfCustomers();
			if(numOfCust %2 ==  0)
			{
				havingEvenNumCust= true;
				if (numOfCust < first)
	            {
	                second = first;
	                first = numOfCust;
	            }
	            else if (numOfCust < second && numOfCust != first)
	                second = numOfCust;
			} 
			
	    }

		if(havingEvenNumCust)
		{
			for(i=0; i<banks.length; i++)
			{
				if(banks[i].getNumberOfCustomers() == second )
					return banks[i];
			}
		}
		return null;
	}
	
	

}
