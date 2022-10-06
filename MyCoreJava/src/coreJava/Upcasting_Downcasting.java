package coreJava;

/*	Upcasting is the typecasting of a child object to a parent object.
  
 * 	Downcasting means the typecasting of a parent object to a child object.
   
*/

class Parent {   
    // A method which prints the data of the parent class   
    void showMessage()   
    {   
        System.out.println("Parent method is called");   
    }   
}   
    
// Child class   
class Child extends Parent {   
   
	// Performing overriding  
    @Override  
    void showMessage()   
    {   
        System.out.println("Child method is called");   
    }   
}   

public class Upcasting_Downcasting {

	public static void main(String[] args) {
	
//		Parent p = new Parent();  
		Parent p = new Child();  
		p.showMessage();   
		
//		Child c = new Parent(); 			// This line will give compile-time error
//		Child c = (Child)new Parent();  	// This line will give "java.lang.ClassCastException" :: class demo.Parent cannot be cast to class demo.Child 
		Child c = (Child)p;   				// This line won't give any compilation error, because at the end "Child c" me jo "p" daal rahe hai wo "new Child()" object se hi bana hai, matlab anyhow CHILD ka object hi hai.  
		
		c.showMessage();   
		
	}
	
}