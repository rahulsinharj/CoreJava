package serialization.xmlDemo;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.List;

public class DeserializeXml {

	public static void main(String[] args) {
		
		try {
			XMLDecoder xml = new XMLDecoder(new BufferedInputStream(new FileInputStream("src/serialization/xmlDemo/myCollege.xml")));
			College college = (College) xml.readObject();
			
			List<Student> sList = college.getStudentList();
			for(Student s : sList) 
			{
				System.out.println(s);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
