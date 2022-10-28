package java8Features.streamApi.sorted;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import java8Features.entity.Employee;

public class SortMAP_Employee {

	public static void main(String[] args) {
	
/*		Map<Employee, Integer> empMap = new TreeMap<>(new Comparator<Employee>() 
		{
			@Override
			public int compare(Employee e1, Employee e2) {
				return (int) (e2.getSalary() - e1.getSalary());			// Salary sorting in Descending order
			}
		});
*/		
		Map<Employee, Integer> empMap = new TreeMap<>((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()) );	// Salary sorting in Descending order
		
		empMap.put(new Employee(175, "Rahul", "CSE", 85000), 60);
		empMap.put(new Employee(385, "Vikash", "IT", 90000), 90);
		empMap.put(new Employee(475, "Shubham", "Electrical", 48000), 50);
		empMap.put(new Employee(625, "Shashank", "Civil", 75000), 40);
		empMap.put(new Employee(225, "Nitish", "Mechanical", 55000), 120);

//		empMap.forEach((e1,i) -> System.out.println(e1 +"==="+i ));
		
		
		empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
								  .forEach(System.out::println);
		System.out.println("------------------------------------");	
		
		empMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
		  						  .forEach(System.out::println);

	}
}
