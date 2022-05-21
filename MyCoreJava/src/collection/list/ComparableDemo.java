package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		
		List<Address> address = new ArrayList<>();
		address.add(new Address(101, 8005));
		address.add(new Address(102, 8015));
		address.add(new Address(103, 8040));
		address.add(new Address(104, 8040));
		address.add(new Address(105, 8080));
		address.add(new Address(106, 8065));
		
		Collections.sort(address);
		
		for(Address ad : address)
		{
			System.out.println(ad);
		}

	}

}

class Address implements Comparable<Address>		// 
{
	int slno;
	int pincode;
	
	public Address(int slno, int pincode) {
		super();
		this.slno = slno;
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [slno=" + slno + ", pincode=" + pincode + "]";
	}

	@Override
	public int compareTo(Address ad) 
	{
		return this.pincode > ad.pincode ? -1 : this.pincode < ad.pincode ? 1 : 0;
	
		
/*		if(this.pincode == ad.pincode)					// If both Pincodes are equal then Sorting based on "slno" - Ascending order
		{
			return this.slno < ad.slno ? -1 : 1 ; 
		}
		else if (this.pincode > ad.pincode) {			// Sorting based on Pincode - Descending order
			return -1;
		}
		else {
			return 1;
		}
*/		
	}
	
	// If this == other 		=> return 0  => No swap, just as it is
	// If this >  other 		=> return 1  => Due to 1 return, numbers will get swaped
	// If this <  other 		=> return 0  => No swap, just as it is
	
	
}