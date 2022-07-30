package java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap_UsingStreamApi {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Rahul", 380000));
        list.add(new Student(2, "Vikash", 90000));
        list.add(new Student(3, "Shubham", 120000));
        list.add(new Student(4, "Shashank", 200000));
        list.add(new Student(5, "Ashish", 151000));

        																// Same with result1, just different syntax key = id, value = name
        Map<Integer, String> result3 = list.stream()
        								   .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);
        
        																	// key = id, value - websites
        Map<Integer, String> result1 = list.stream()
        								   .collect(Collectors.toMap(Student::getId, Student::getName));

        System.out.println("Result 1 : " + result1);

        																	// key = name, value - websites
        Map<String, Long> result2 = list.stream()
        								.collect(Collectors.toMap(Student::getName, Student::getSalary));

        System.out.println("Result 2 : " + result2);

	}
}

class Student {

    private int id;
    private String name;
    private long salary;
    
	public Student(int id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

