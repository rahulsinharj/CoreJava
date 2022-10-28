package CoreJAVA;
								// https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/
import java.util.HashMap;
import java.util.Map;

class Person {
	String name;
	int id;

	Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + id + "]";
	}

	@Override
	public boolean equals(Object obj) 
	{
		// if both the object references are referring to the same object.
		if (this == obj) {
			return true;
		}
		
		// it checks if the argument is of the type Person class by comparing the classes of the passed argument and this object.
		// if(!(obj instanceof Person)) return false; ---> avoid.
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		// type casting of the argument.
		Person person = (Person) obj;

		// comparing the state of argument with the state of 'this' Object.
		return (this.name.equals(person.name) && this.id == person.id);
	}

	@Override
	public int hashCode() 
	{
		int result = this.name != null ? name.hashCode() : 0;			// hashcode() of 'Person_name' will get stored in 'result'.   
		result = 31 * result + this.id;									// uss result me kuch aur customized calculation karege (product*31) + Person_id => this final hascodeValue to be returned.			
		
		return result;
		
		// We are returning (Person_name.hashcode()*31 + Person_id) as a hashcode value.
		// we can also return some other calculated value or may be memory address of the Object on which it is invoked.
		// it depends on how you implement hashCode() method.
				//		return this.id;
	}
	
}

public class Hashcode_and_Equals_Map {

	public static void main(String[] args) {

		// creating two Objects with same state
		Person g1 = new Person("aditya", 1);
		Person g2 = new Person("aditya", 1);

		Map<Person, String> map = new HashMap<Person, String>();
		map.put(g1, "CSE");
		map.put(g2, "IT");			// since Person g1 & g2 are same(as per content & equal & hascode method), so this means KEY is same, for its value "CSE" will be overrided to "IT".     

		System.out.println(map);
		
//		for (Person person : map.keySet()) {
//			System.out.println(map.get(person).toString());
//		}

	}
}
