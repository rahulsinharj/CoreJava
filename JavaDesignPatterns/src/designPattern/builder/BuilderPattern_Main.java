package designPattern.builder;

public class BuilderPattern_Main {

	public static void main(String[] args) {
		
//		new Student.StudentBuilder("Rahul").setAge(23).build();
		
		Student stu = new Student.StudentBuilder("Sneha").setAge(21).setCity("Patna").setSubject("Commerce").build();
		
		System.out.println(stu);
		
	}

}
