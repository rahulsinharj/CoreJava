package designPatternType_CREATIONAL.Builder_Example1;

public class BuilderPattern_Main {

	public static void main(String[] args) {

		Student stu1 = new Student.StudentBuilder("Rahul").setAge(23).setCity("Delhi").setSubject("Science").build();
		System.out.println(stu1);
		
		Student stu2 = new Student.StudentBuilder("Sneha").setAge(21).setCity("Patna").setSubject("Commerce").build();
		System.out.println(stu2);

	}

}
