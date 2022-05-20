package collection.generics;

class Container<T>
{
	T value;

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public void show()
	{
		System.out.println(value.getClass().getName());
	}
}

public class CustomGenerics {

	public static void main(String[] args) 
	{
		Container<String> obj1 = new Container<>();
		obj1.setValue("Rahul");
		obj1.show();
		
		Container<Integer> obj2 = new Container<>();
		obj2.setValue(5);
		obj2.show();
		
		
		
	}

}
