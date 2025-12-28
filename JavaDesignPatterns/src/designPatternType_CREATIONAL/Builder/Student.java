package designPatternType_CREATIONAL.Builder;

public class Student 
{
	private String name;
	private int age;
	private String city;
	private String subject;
	
	private Student(StudentBuilder studentBuilder) {		// Outer class constructor should be private, only accessible to inner class. 
		this.name = studentBuilder.name;
		this.age = studentBuilder.age;
		this.city = studentBuilder.city;
		this.subject = studentBuilder.subject;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getCity() {
		return city;
	}
	public String getSubject() {
		return subject;
	}
	
	@Override
	public String toString() {
		return "Student [name= " + name + ", age= " + age + ", city= " + city + ", subject= " + subject + "]";
	}

	// INNER CLASS for Builder pattern ::
	public static class StudentBuilder
	{
		private String name;
		private int age;
		private String city;
		private String subject;
		
		public StudentBuilder(String name) {				// Setting name exceptionally from StudentBuilder constructor
			this.name = name;
		}
/*		public StudentBuilder setName(String name) {
			this.name = name;
			return this;
		}
*/		public StudentBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		public StudentBuilder setCity(String city) {
			this.city = city;
			return this;
		}
		public StudentBuilder setSubject(String subject) {
			this.subject = subject;
			return this;
		}
		
		public Student build()
		{
			return new Student(this);
		}
		
	}
	
}
