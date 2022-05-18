package java8Features.streamApi.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi_Filter_FlatMap2 {

	public static void main(String[] args) {
	
		List<Cricketer> crList = new ArrayList<Cricketer>();
		crList.add(new Cricketer(1001, "Rahul", Arrays.asList("bat", "ball", "helmet")));
		crList.add(new Cricketer(1002, "Ravi", Arrays.asList("pad", "bat", "stump")));
		crList.add(new Cricketer(1003, "Shubham", Arrays.asList("handpad", "football", "gloves")));
		crList.add(new Cricketer(1004, "Vikash", Arrays.asList("belt", "helmet", "ball")));

		// Print the items (remove duplicates) from all the Cricketers ::
		Set<String> collectAllListItems = crList.stream()							// Convert the List into Stream
												.map(cr -> cr.items)				// Map transforms one obj into another form, here each "Cricketer obj" is transformed into Cricketer.items   
												.flatMap(Collection::stream)		// Convert the "Stream <List<String>>" into "Stream <String>" ; since Cricketer.items is List<String> not String.   
												.collect(Collectors.toSet());		// Collecting the stream into SET(for removing duplicate items) 	// We can also use Collectors.toList() - duplicate items will remain here.       
		
		System.out.println(collectAllListItems);
		
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
