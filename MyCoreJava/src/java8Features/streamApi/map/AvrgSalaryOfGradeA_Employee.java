package java8Features.streamApi.map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8Features.entity.EmployeeG;

public class AvrgSalaryOfGradeA_Employee {

	public static void main(String[] args) {
		
		List<EmployeeG> myemployees = getEmployees();

		myemployees.stream().filter(emp -> emp.getGrade().equalsIgnoreCase("A")).forEach(System.out::println);
		
		double sumSalaryOfAgradeEmp = myemployees.stream()
												 .filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
												 .map(emp -> emp.getSalary())
												 .mapToDouble(i->i).sum();
		
		System.out.println("SumSalaryOfAgradeEmp : "+sumSalaryOfAgradeEmp);
	
		
		double avgSalaryOfAgradeEmp = myemployees.stream()
												 .filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
												 .map(emp -> emp.getSalary())
												 .mapToDouble(i -> i).average().getAsDouble();

		System.out.println("AvgSalaryOfAgradeEmp : "+avgSalaryOfAgradeEmp);
	
	}

	
	public static List<EmployeeG> getEmployees()
	{
		return Stream.of(new EmployeeG(102, "Rahul", "A", 80000) , 
						 new EmployeeG(109, "Vikash", "B", 90000),
						 new EmployeeG(105, "Shubham", "A", 40000),
						 new EmployeeG(108, "Shashank", "C", 70000),
						 new EmployeeG(104, "Vivek", "C", 30000),
						 new EmployeeG(107, "Nitish", "A", 50000)
				).collect(Collectors.toList());
	}
	
	
}
