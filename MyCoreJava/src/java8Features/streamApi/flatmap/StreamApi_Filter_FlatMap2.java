package java8Features.streamApi.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi_Filter_FlatMap2 {

	public static void main(String[] args) {
	
		List<Cricketer> crList = new ArrayList<Cricketer>();
		crList.add(new Cricketer(1001, "Rahul", Arrays.asList("bat", "ball", "helmet")));
		crList.add(new Cricketer(1002, "Ravi", Arrays.asList("pad", "bat", "stump")));
		crList.add(new Cricketer(1003, "Shubham", Arrays.asList("handpad", "football", "gloves")));
		crList.add(new Cricketer(1004, "Vikash", Arrays.asList("belt", "helmet", "ball")));

		// Print the items (remove duplicates) from all the Cricketers ::
		Set<String> collectAllSetItems = crList.stream()							// Convert the List into Stream
												.map(cr -> cr.items)				// Map transforms one obj into another form, here each "Cricketer obj" is transformed into Cricketer.items   
												.flatMap(Collection::stream)		// Convert the "Stream of <List<String>>" into "Stream of <String>" ; since Cricketer.items is List<String> not String.   
												.collect(Collectors.toSet());		// Collecting the stream into SET(for removing duplicate items) 	// We can also use Collectors.toList() - but duplicate items will remain here.       
		
		System.out.println(collectAllSetItems);		// Order of ITEMS is not preserved , since we have collected into SET.
		
//------------------------------------------------		
		crList.stream()
		  .map(cr -> cr.items)				
		  .flatMap(Collection::stream)	
		  .distinct()									// Distinct Non Duplicate items - Returning "Stream<String>"
		  .forEach(x -> System.out.print(x +" "));		// Directly printing through forEach method	// Order of ITEMS is preserved here. 

		System.out.println();

//------------------------------------------------

		List<String> collectList = crList.stream()
      		  .map(cr -> cr.items)				
      		  .flatMap(items -> items.stream())	
      		  .distinct()								// Distinct Non Duplicate items - Returning "Stream<String>"
      		  .collect(Collectors.toList());			// Storing that List and then printing	// Order of ITEMS is preserved here. 

		System.out.println(collectList);
		
//------------------------------------------------

		List<String> collectedList = crList.stream()
      		  .flatMap(cr -> cr.items.stream())			// Using MAP & FLAT-mapping in same function
      		  .distinct()								// Returning "Stream<String>"
      		  .collect(Collectors.toList());			// Order of ITEMS is preserved here. // and Storing that List

		System.out.println(collectedList);
				
	}
}

class Cricketer
{
	int id;
	String name;
	List<String> items;
	
	public Cricketer(int id, String name, List<String> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cricketer [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
	
	
	
}
