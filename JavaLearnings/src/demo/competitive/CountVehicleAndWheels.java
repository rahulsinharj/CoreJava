package demo.competitive;

import java.util.Scanner;

public class CountVehicleAndWheels 
{
	public static final void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		int vehicles = in.nextInt(); 
		int wheels = in.nextInt(); 
		
		if (wheels % 2 == 1 || wheels < 2 || wheels <= vehicles) 
		{ 	
			System.out.print ("INVALID INPUT");
			return;
		}

		int wheels_cars = vehicles*4; 					// Number of expected wheels if all given vehicles are to be cars.

		int surplus_wheels = wheels_cars - wheels; 		// If all the vehicles were to be cars, // number of extra wheels that would be required more than given wheels.

		int no_of_bikes = surplus_wheels / 2;

		int no_of_cars = vehicles - no_of_bikes; 
		
		System.out.print (no_of_bikes + "\n" + no_of_cars);

		
	}

}