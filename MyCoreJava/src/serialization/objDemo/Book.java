package serialization.objDemo;

import java.io.Serializable;

public class Book implements Serializable
{
	private String name;		// Member variables
    
	Book(String name)
    {
		this.name = name;
    }

	@Override
	public String toString() {
		return "A [name= " + name + "]";
	}
	
}
