package serialization.xmlDemo;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeXml {						// Here even if we change the structure of Student Class, it will not affect the output.

	public static void main(String[] args)
	{
		Student s1 = new Student();
		s1.setRollno(101);
		s1.setSname("RahulS");
		
		Student s2 = new Student();
		s2.setRollno(102);
		s2.setSname("Vikash");
		
		Student s3 = new Student();
		s3.setRollno(105);
		s3.setSname("Shubham");
		
		List<Student> sList = new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		
		College college = new College();
		college.setStudentList(sList);
		
		try {
			XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src/serialization/xmlDemo/myCollege.xml")));
			xml.writeObject(college);
			xml.close();
			System.out.println("Serialization Successfull !");
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

