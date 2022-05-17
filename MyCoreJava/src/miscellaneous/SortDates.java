package miscellaneous;

import java.util.*;  
class DateI  
{  
    String date;   
 
    DateI(String date) 
    {  
        this.date = date;  						// This keyword is used to refer current object. 
    }  
}  
class sortCompare implements Comparator<DateI>   
{  
    @Override  
    public int compare(DateI a, DateI b)  
    {  
        return a.date.compareTo(b.date);  		// Returns sorted data in ascending order */  
    }  
}  

public class SortDates   
{  
    public static void main(String args[])  
    {  
        ArrayList<DateI> dates = new ArrayList<>();  
        
        dates.add(new DateI("2021-05-14"));  			// Adding data to the ArrayList.  
        dates.add(new DateI("2019-06-24"));  	
        dates.add(new DateI("1998-02-20"));  
        dates.add(new DateI("1999-04-26"));  
       
        Collections.sort(dates, new sortCompare());  	// Sort the ArrayList with Collections.sort() method.
        System.out.println("Dates sorted in Ascending Order");  
        for (DateI d : dates) {  
            System.out.println(d.date);  
        }  
    }  
}  