package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		
		List<Address> address = new ArrayList<>();
		address.add(new Address(105, "Patna"));
		address.add(new Address(104, "Gaya"));
		address.add(new Address(153, "Delhi"));
		address.add(new Address(111, "Delhi"));
		address.add(new Address(102, "Noida"));
		address.add(new Address(109, "Gurgaon"));
		address.add(new Address(107, "Assam"));
		
		Collections.sort(address);
		
		for(Address ad : address)
		{
			System.out.println(ad);
		}

	}

}

/*	If you are going with Custom class Generic type. eg- List<Address> , then go for it s advisible to implement Comparable<Address> interface.  
  
 * 	Here below - Address class "after implementing Comparable" , now itself know that how to sort their own objects.
 * 	Now this Address class obj will itself either by pincode/city or by some different logic 
  			=> That mean this class now no longer needs "Comparator<>" object. 
  			
 *	For that we have to implement Comparable<> and overrider 1 method "compareTo()" by putting our own sorting logic.
  	
*/
class Address implements Comparable<Address>		 
{
	int pincode;
	String city;
	
	public Address(int pincode, String city) {
		super();
		this.pincode = pincode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", city=" + city + "]";
	}

	@Override
	public int compareTo(Address ad) 
	{
		int cityCompare = this.city.compareTo(ad.city);
		
		if(cityCompare == 0)			// If both city are equal then Sorting based on "pincode" - Ascending order
		{
//			return this.pincode < ad.pincode ? -1 : (this.pincode > ad.pincode ? 1 : 0);
			return this.pincode - ad.pincode;
		}
		else {							// Sorting based on city {Ascending order}, 	
			return cityCompare;						// if both city are unequal {and provides some +ve or -ve values in "cityCompare" through compareTo} 
		}
		
	
	// 	If this == other 		=> return 0  => No swap, just as it is
	// 	If this >  other 		=> return 1  => Due to 1 return, numbers will get swaped
	// 	If this <  other 		=> return 0  => No swap, just as it is
	
	}
}