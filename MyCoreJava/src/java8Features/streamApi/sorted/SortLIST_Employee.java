package java8Features.streamApi.sorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java8Features.entity.Employee;

/*	If we have Custom class , and we want to do sorting based on a specific field (based on EmpId, or EmpSalary - we want to sort)
  		In that case we need to write our own custom compare() logic - using Comparator<> or Comparable<>	
*/
//	SORTING CUSTOM-CLASS - based on a SPECIFIC FIELD ::
public class SortLIST_Employee {

	public static void main(String[] args) {
	
		List<Employee> elist = new ArrayList<>();
		elist.add(new Employee(175, "Rahul", "CSE", 85000));
		elist.add(new Employee(385, "Vikash", "IT", 90000));
		elist.add(new Employee(475, "Shubham", "Electrical", 48000));
		elist.add(new Employee(625, "Shashank", "Civil", 75000));
		elist.add(new Employee(225, "Nitish", "Mechanical", 55000));

//============[Sorting using Traditional approach ::]=============

		Comparator<Employee> comp = new Comparator<Employee>() 
		{
			@Override
			public int compare(Employee e1, Employee e2) 
			{
				return (int) (e2.getSalary() - e1.getSalary());			// Sorting by Salary 	- Descending order
//				return (e1.getId() - e2.getId());						// Sorting by EmpId  	- Ascending order
//				return e1.getName().compareTo(e2.getName());			// Sorting by EmpName  	- Ascending order
			}
		};	
				
//		Collections.sort(elist, comp);				// Custom Sorting using "Anonymous class implementation" of Comparator<Employee> functional interface

		Collections.sort(elist, (e1,e2) -> (int)(e2.getSalary() - e1.getSalary()));		// Custom Sorting using "Lambda implementation" of Comparator<Employee> functional interface
		elist.forEach(System.out::println);
		System.out.println("------------------------------------");
		
//============[Sorting using StreamAPI approach ::]=============// Stream<Employee> java.util.stream.Stream.sorted(Comparator<? super Employee> comparator)
			
		elist.stream().sorted((e1,e2) -> (int)(e2.getSalary() - e1.getSalary())).forEach(System.out::println);
		System.out.println("------------------------------------");
		
//=====[Using method reference ::]========// <T, U> Comparator<T> java.util.Comparator.comparing(Function<? super T, ? extends U> keyExtractor)	// just like map() method => emp -> emp.getSalary()
	
//		elist.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);			// Salary-based Emp sorting - Ascending order
//		System.out.println("------------------------------------");
		
		elist.stream().sorted(Comparator.comparing(Employee :: getId)).forEach(System.out::println);				// Id-based Emp sorting - Ascending order
		System.out.println("------------------------------------");
		
		elist.stream().sorted(Comparator.comparing(Employee :: getId).reversed()).forEach(System.out::println);		// Id-based Emp sorting - Descending order
		System.out.println("------------------------------------");
		
		
	}
}


