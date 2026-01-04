package designPatternType_BEHAVIORAL.Observer.OrderStatusNotificationSystem;

import java.util.ArrayList;
import java.util.List;

/* 	We will implement an Order Status Notification System.
	Subject: Order (Stores state: "Cooking", "Out for Delivery").
	Observers: Customer, DeliveryPartner.
*/

//===============[Step A: The Observer Interface]===============

//This is the contract. Every "subscriber" must implement this to receive updates.

interface OrderObserver {
	// The method called when the Subject changes
	void update(String orderId, String status);
}

//===============[Step B: The Subject Interface]===============

//Defines how to Manage (Add/Remove) and Notify subscribers.

interface Subject {
	void attach(OrderObserver observer); // Subscribe

	void detach(OrderObserver observer); // Unsubscribe

	void notifyObservers(); // Broadcast change
}

//===============[Step C: The Concrete Subject (The Order)]===============

//This class holds the actual data and the list of subscribers.

class Order implements Subject {
	private String orderId;
	private String status;
	// The list of "Subscribers"
	private List<OrderObserver> observers = new ArrayList<>();

	public Order(String orderId) {
		this.orderId = orderId;
		this.status = "Placed";
	}

	public String getStatus() {
		return status;
	}

	// Logic to change status and trigger notification
	public void setStatus(String newStatus) {
		this.status = newStatus;
		System.out.println("\n--- Order Status Changed to: " + newStatus + " ---");
		notifyObservers(); // The magic happens here
	}

	@Override
	public void attach(OrderObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(OrderObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (OrderObserver observer : observers) {
			observer.update(this.orderId, this.status);
		}
	}
}

//===============[Step D: Concrete Observers]===============

//The different parties interested in the Order.

// 1. The Customer (App Notification)
class Customer implements OrderObserver {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public void update(String orderId, String status) {
		System.out.println("Displaying to User (" + name + "): Order " + orderId + " is now " + status);
	}
}

// 2. The Delivery Driver (App Alert)
class DeliveryDriver implements OrderObserver {
	private String driverName;

	public DeliveryDriver(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public void update(String orderId, String status) {
		if ("Ready for Pickup".equals(status)) {
			System.out.println("Alerting Driver (" + driverName + "): Hurry up! Order " + orderId + " is ready.");
		} else {
			System.out.println("Driver (" + driverName + "): Monitoring Order " + orderId + " status: " + status);
		}
	}
}

//===============[Step E: The Client (Testing the Pattern)]===============

public class ZomatoApp {
	public static void main(String[] args) {
		// 1. Create the Subject
		Order order = new Order("ORD-999");

		// 2. Create Observers
		Customer customer = new Customer("Rahul");
		DeliveryDriver driver = new DeliveryDriver("Manoj");

		// 3. Attach Observers (Subscription)
		order.attach(customer);
		order.attach(driver);

		// 4. Change State (Simulating the Kitchen flow)
		order.setStatus("Cooking");
		// Output: Both Customer and Driver are notified.

		order.setStatus("Ready for Pickup");
		// Output: Driver gets specific "Hurry up" alert. Customer gets notified.

		order.setStatus("Out for Delivery");

		// 5. Unsubscribe (Driver doesn't care anymore)
		order.detach(driver);
		order.setStatus("Delivered");
		// Output: Only Customer is notified.
	}
}
