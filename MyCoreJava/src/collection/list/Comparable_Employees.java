package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparable_Employees {

	public static void main(String[] args) {
	
		List<Employees> empList = new ArrayList<Employees>();
		
		empList.add(new Employees(101, "Rohit", 50000));
		empList.add(new Employees(102, "Rahul", 50000));
		empList.add(new Employees(103, "Vikas", 40000));
		empList.add(new Employees(104, "Shubham", 44000));
		empList.add(new Employees(104, "Shivam", 44000));
		empList.add(new Employees(105, "Shashank", 48000));
		
		Collections.sort(empList);
		
		empList.forEach(System.out::println);
		
		
	}
}

class Employees implements Comparable<Employees>
{
	int id;
	String name;
	int salary;
	
	public Employees() {
		super();
	}
	public Employees(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [id= " + id + ", name= " + name + ", salary= " + salary + "]";
	}

	@Override
	public int compareTo(Employees emp2) 
	{
		int salaryCompare = this.salary - emp2.salary;
		
		if(salaryCompare == 0)			// If both salaries are equal then Sorting should be based on "name" - Ascending order
		{
			return this.name.compareTo(emp2.name);
		}
		else 
		{								// Sorting based on salary {Ascending order}, 	
			return salaryCompare;		
		}
		
	}
	
	
	
}
