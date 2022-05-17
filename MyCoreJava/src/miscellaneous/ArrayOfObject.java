package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

class Emp {
	int a;
	int b;
	int c;
	
	public Emp() {
	}
	
	public Emp(int a, int b, int c)	{
		this.a = a ;
		this.b = b ; 
		this.c = c ;
	}
	
}

public class ArrayOfObject {

	public static void main(String[] args) {

		Emp[] emps = new Emp[3];				// Array of Object/Class => matlab ki emps naam ke array ke har block me ek-ek Emp ka object hoga
		emps[0] = new Emp();
		emps[0].a = 1;
		emps[0].b = 1;
		emps[0].c = 1;
		
		emps[1] = new Emp(2,2,2);
		
		emps[2] = new Emp();
		
		for(Emp emp : emps)
		{
			System.out.println(emp.a +" "+emp.b +" "+emp.c);
		}
		
		
//--------------------------------------------------------------------
		
		ArrayList<Integer>[] books = new ArrayList[2];		//Array of Arraylist<Integer> => matlab ki books naam ke array ke har block me ek-ek Arraylist<Integer> ka object hoga
		
		books[0] = new ArrayList<>();
		books[0].add(7);
		books[0].add(2);
		books[0].add(5);
		
		books[1] = new ArrayList<>();
		books[1].add(3);
		books[1].add(4);
		books[1].add(9);
		
		for(ArrayList<Integer> book: books) {
		      Collections.sort(book);
		}
		
		for (int i =0; i<books.length; i++) 
		{
			for (int j =0 ; j<books[i].size(); j++) {
				System.out.print(books[i].get(j)+ " ");
			}
		}
			 
	}
	
}



	



