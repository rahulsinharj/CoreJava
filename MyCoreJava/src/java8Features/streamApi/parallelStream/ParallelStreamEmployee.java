package java8Features.streamApi.parallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java8Features.entity.EmployeeG;

public class ParallelStreamEmployee {

	public static void main(String[] args) {
		
		long start = 0;
		long end = 0;

		List<EmployeeG> empList = new ArrayList<EmployeeG>();
		
		for(int i=1; i<1000; i++)
		{
			empList.add(new EmployeeG(i, "Employee"+i, "A", Double.valueOf(new Random().nextInt(1000*10))));
		}
		
		start = System.currentTimeMillis();
		double salaryWithStream = empList.stream().map(EmployeeG::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
	
		System.out.println("Normal Stream execution time : "+(end-start) +" | Average SalaryWithStream = "+salaryWithStream);

System.out.println("=========================================");		

		start = System.currentTimeMillis();
		double salaryWithParallelStream = empList.parallelStream().map(EmployeeG::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		
		System.out.println("Parallel Stream execution time : "+(end-start) +" | Average SalaryWithParallelStream = "+salaryWithParallelStream);

		
		
	}
}
