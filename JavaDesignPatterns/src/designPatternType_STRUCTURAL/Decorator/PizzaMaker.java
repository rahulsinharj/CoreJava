package designPatternType_STRUCTURAL.Decorator;

/*Key Components:
  1. Component (Interface): The common interface for both the main object and the wrappers (e.g., Coffee).
  2. ConcreteComponent (Base): The object being wrapped (e.g., Espresso).
  3. Decorator (Abstract Wrapper): The crucial class. It implements the Component interface AND holds a reference to a Component.
  4. ConcreteDecorator: The specific add-on (e.g., Milk, Sugar).
*/

//================================[The Pizza Cost Calculator]================================
//Let's build a Pizza pricing system where users can stack toppings.

//===============[Step A: The Component Interface]===============
//Defines what a "Pizza" looks like.

interface Pizza {
	String getDescription();

	double getCost();
}

//===============[Step B: The Concrete Component (The Base)]===============
//The basic pizza without any toppings.

class PlainPizza implements Pizza {
	@Override
	public String getDescription() {
		return "Thin Dough";
	}

	@Override
	public double getCost() {
		return 4.00; // Base price
	}
}

//===============[Step C: The Abstract Decorator]===============

// This is the most important part.
// It implements Pizza (so it looks like a pizza).
// It holds a Pizza (so it can wrap a pizza).

// It IS A Pizza, but it also HAS A Pizza
abstract class ToppingDecorator implements Pizza {
	protected Pizza tempPizza; // The object we are wrapping

	public ToppingDecorator(Pizza newPizza) {
		this.tempPizza = newPizza;
	}

	public String getDescription() {
		return tempPizza.getDescription();
	}

	public double getCost() {
		return tempPizza.getCost();
	}
}

//===============[Step D: Concrete Decorators (The Toppings)]===============
//These add their own behavior and then delegate to the inner object.

// Topping 1: Mozzarella
class Mozzarella extends ToppingDecorator {
	public Mozzarella(Pizza newPizza) {
		super(newPizza); // Wrap the incoming pizza
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription() + ", Mozzarella";
	}

	@Override
	public double getCost() {
		return tempPizza.getCost() + 0.50; // Add cost
	}
}

// Topping 2: Tomato Sauce
class TomatoSauce extends ToppingDecorator {
	public TomatoSauce(Pizza newPizza) {
		super(newPizza);
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription() + ", Tomato Sauce";
	}

	@Override
	public double getCost() {
		return tempPizza.getCost() + 0.35;
	}
}

//===============[Step E: The Client (Stacking Layers)]===============

public class PizzaMaker {
	public static void main(String[] args) {
		// 1. Create a plain pizza
		Pizza pizza = new PlainPizza();

		// 2. Wrap it with Mozzarella
		pizza = new Mozzarella(pizza);

		// 3. Wrap it with Tomato Sauce
		pizza = new TomatoSauce(pizza);

		// Alternatively, do it in one line (The "Onion" structure)
		// Pizza complexPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

		System.out.println("Desc: " + pizza.getDescription());
		// Output: Thin Dough, Mozzarella, Tomato Sauce

		System.out.println("Price: $" + pizza.getCost());
		// Output: 4.00 + 0.50 + 0.35 = $4.85
	}
}
