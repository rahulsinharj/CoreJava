package collection.generics;

class MyContainer<T extends Number>
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

public class CustomGenericsNum {

	public static void main(String[] args) 
	{
		MyContainer<Integer> obj2 = new MyContainer<>();
		obj2.setValue(5);
		obj2.show();
		
		MyContainer<Double> obj1 = new MyContainer<>();
		obj1.setValue(5.5);
		obj1.show();
		
//		MyContainer<String> obj1 = new MyContainer<>();		// Since MyContainer class only accepts Generics which is of type "Number" / or child class of "Number" ; eg- Intger, Float, Long, Double  
//		obj1.setValue("Rahul");										// Since "String" class is not child class of Number , therefore Sting Generics is not acceptable here. 	
//		obj1.show();
		

	}

}
