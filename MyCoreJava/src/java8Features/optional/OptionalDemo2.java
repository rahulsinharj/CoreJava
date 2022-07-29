package java8Features.optional;

import java.util.ArrayList;
import java.util.List;

//	Optional class provides a solution for "representing optional values" instead of null references.
public class OptionalDemo2 {

	private static List<Teacher> tlist = new ArrayList<>();
	
	public static void main(String[] args) 
	{				
		tlist.add(new Teacher(101, "Nirbhay Sinha", "Maths"));
		tlist.add(new Teacher(102, "Rahul Sinha", "Science"));
		tlist.add(new Teacher(103, "Sheha Sinha", "Economy"));
		
		
		Teacher teacher1 = getSingleTeacherById(102);
		System.out.println(teacher1);
		
	}
	
	// Get single Book by ID
	public static Teacher getSingleTeacherById(int findId) 
	{
		Teacher teacher = null;
		try 
		{															// findAny()	
			teacher = tlist.stream().filter(t -> t.getTid() == findId).findFirst().orElse(null);			// Here just NULL will be returned, without any EXCEPTION. 

//			teacher = tlist.stream().filter(t -> t.getTid() == findId).findFirst().get();					// Here Compiler will get EXCEPTION as well.
//			teacher = tlist.stream().filter(t -> t.getTid() == findId).collect(Collectors.toList()).get(0);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return teacher;
	}
}

class Teacher {

	private int tid;
	private String tname;
	private String tsubject;
	
	public Teacher(int tid, String tname, String tsubject) {
		this.tid = tid;
		this.tname = tname;
		this.tsubject = tsubject;
	}

	public int getTid() {
		return tid;
	}
	public String getTname() {
		return tname;
	}
	public String getTsubject() {
		return tsubject;
	}

	@Override
	public String toString() {
		return "Teacher [tid= " + tid + ", tname= " + tname + ", tsubject= " + tsubject + "]";
	}
	
	
}	
