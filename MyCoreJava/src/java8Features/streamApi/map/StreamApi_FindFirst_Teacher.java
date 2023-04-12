package java8Features.streamApi.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApi_FindFirst_Teacher {

	public static void main(String[] args) {
		
		Teacher t = getSingleTeacherById(102);		// Try for 104
		System.out.println(t);	
	}

	private static List<Teacher> tlist = new ArrayList<>();

	static {
		tlist.add(new Teacher(101, "Nirbhay Sinha", "Maths"));
		tlist.add(new Teacher(102, "Rahul Sinha", "Science"));
		tlist.add(new Teacher(103, "Vikash Sharma", "Geography"));
	}
	
	// Get single Book by ID
	public static Teacher getSingleTeacherById(int id) 
	{
		Teacher teacher = null;
		try 
		{																				// findAny()	
//			teacher = tlist.stream().filter(t -> t.getTid() == id).findFirst().get();							// Here Compiler will get EXCEPTION as well.
			teacher = tlist.stream().filter(t -> t.getTid() == id).findFirst().orElse(null);					// Here just NULL will be returned, without any EXCEPTION. 
//			teacher = tlist.stream().filter(t -> t.getTid() == id).collect(Collectors.toList()).get(0);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}
}

 class Teacher
 {
	 int tid;
	 String name;
	 String subject;
	 
	public Teacher() {
		super();
	}

	public Teacher(int tid, String name, String subject) {
		super();
		this.tid = tid;
		this.name = name;
		this.subject = subject;
	}
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", subject=" + subject + "]";
	}
	 
	 
 }
