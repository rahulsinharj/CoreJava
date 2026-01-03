package designPatternType_CREATIONAL.Factory;

/*
//Step 1: Product interface
interface Notification {
	void send(String message);
}

//Step 2: Concrete products
class EmailNotification implements Notification {
	public void send(String message) {
		System.out.println("EMAIL: " + message);
	}
}

class SmsNotification implements Notification {
	public void send(String message) {
		System.out.println("SMS: " + message);
	}
}
*/

//❗ Simple Factory (core issue is here)
class NotificationFactory {

	public static Notification createNotification(String type) {

		if ("EMAIL".equalsIgnoreCase(type)) {
			return new EmailNotification();
		} else if ("SMS".equalsIgnoreCase(type)) {
			return new SmsNotification();
		}

		throw new IllegalArgumentException("Invalid type");
	}
}

//Client
public class SimpleFactory_Client {
	public static void main(String[] args) {
		Notification notification = NotificationFactory.createNotification("EMAIL");

		notification.send("Hello");
	}
}
