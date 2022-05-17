package serialization.objDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeObject {

	public static void main(String[] args) {

	// SERIALIZATION ::
		try {
			// Creating object of A class , and Serializing it in file.txt format 
			Book objA = new Book("RahulSPublication");

			FileOutputStream fos = new FileOutputStream("src/serialization/objDemo/bookfile.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objA);
			oos.close();

			fos.close(); // Freeing up memory resources
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	// DESERIALIZATION ::
		try {
			// Creating object of A class , using deserializing file.txt 

            Book objA;
 
            // Creating FileInputStream class object
            FileInputStream fis = new FileInputStream("src/serialization/objDemo/bookfile.txt");
 
            // Creating ObjectInputStream class object
            ObjectInputStream ois = new ObjectInputStream(fis);
            objA = (Book)ois.readObject();
            System.out.println(objA);
            
            fis.close(); // Freeing up memory resources
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}
}
