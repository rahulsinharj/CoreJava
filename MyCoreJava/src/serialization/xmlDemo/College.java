package serialization.xmlDemo;

import java.util.List;

public class College {

	private List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "College [studentList=" + studentList + "]";
	}


	
}
