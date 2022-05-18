package java8Features.streamApi.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi_Filter2_Car {

	public static void main(String[] args) {
		
		List<Car> carList = Arrays.asList(
								new Car("Toyota", "Black", 62000) ,
								new Car("Benz", "White", 55000) ,
								new Car("BMW", "Yellow", 70000) ,
								new Car("Hyundai", "Black", 68000) ,
								new Car("Tata", "White", 40000) ,
								new Car("Maruti", "Silver", 48000)
							);
		
		System.out.println(carList);
		
		Predicate<Car> pred = new Predicate<Car>() {
			@Override
			public boolean test(Car c) 
			{
				return c.getPrice() >= 60000;
			}
			
		};
		
//		List<Car> newList = carList.stream().filter(pred).collect(Collectors.toList());

//		List<Car> newList = carList.stream().filter(c -> c.getName().contains("T")).collect(Collectors.toList());

		List<Car> newList = carList.stream().filter(c -> c.getPrice() >= 60000).collect(Collectors.toList());

		for(Car c: newList)
		{
			System.out.println(c);
		}
	
	}
}

class Car
{
	private String name;
	private String color;
	private double price;
	
	public Car(String name, String color, double price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", price=" + price + "]";
	}
	
	
	
}
