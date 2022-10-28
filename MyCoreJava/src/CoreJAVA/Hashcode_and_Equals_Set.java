package CoreJAVA;
								// https://www.techiedelight.com/why-override-equals-and-hashcode-methods-java/
import java.util.HashSet;
import java.util.Set;

class Employee {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "{" + name + ", " + salary + "}";
	}

	@Override
	public boolean equals(Object obj) 
	{
		// if both the object references are referring to the same object.
		if (this == obj) {
			return true;
		}
		
		// it checks if the argument is of the type Employee class by comparing the classes of the passed argument and this object.
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Employee employee = (Employee) obj;

		// comparing the state of argument with the state of 'this' Object.
		return (this.name.equals(employee.name) && this.salary == employee.salary);
	}

	@Override
	public int hashCode() 
	{
		int result = this.name != null ? this.name.hashCode() : 0;
		result = 31 * result + this.salary;
		
		return result;
	}
	
}

public class Hashcode_and_Equals_Set 
{
	// Program to demonstrate the need for overriding `equals` and `hashCode` method in Java
	public static void main(String[] args) 
	{
		Employee e1 = new Employee("John", 80000);
		System.out.println("e1 hashcode : "+e1.hashCode());
		
		Employee e2 = new Employee("John", 80000);
		System.out.println("e2 hashcode : "+e2.hashCode());

		Set<Employee> employeeSet = new HashSet<>();

		employeeSet.add(e1);
		employeeSet.add(e2);

		System.out.println(employeeSet);
	}
}

/*	We know that two objects are considered equal only if their references point to the same object, 
  		and unless we override equals and hashCode methods, the class object will not behave properly 
  		on hash-based collections like HashMap, HashSet, and Hashtable. 
 * 	This is because hash-based collections are organized like a sequence of buckets, 
  		and the hash code value of an object is used to determine the bucket where the object would be stored, 
  		and the same hash code is used again to find the object’s position in the bucket. 
  	

 * 	The key retrieval is basically a two-step process:
	
	-  Finding the correct bucket using hashCode() method.
	-  Linearly searching the bucket for the key using equals() method.
		  
*/

