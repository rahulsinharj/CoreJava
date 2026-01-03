package designPatternType_CREATIONAL.Factory;

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

//Step 3: Creator (declares factory method)
abstract class NotificationCreator {

	public void notifyUser(String message) {
		Notification notification = createNotification();
		notification.send(message);
	}

	protected abstract Notification createNotification();
}

//Creator uses product, but doesn't know concrete type.
//Step 4: Concrete creators
class EmailNotificationCreator extends NotificationCreator {

	protected Notification createNotification() {
		return new EmailNotification();
	}
}

class SmsNotificationCreator extends NotificationCreator {

	protected Notification createNotification() {
		return new SmsNotification();
	}
}

//Step 5: Client
public class FactoryMethod_Client {
	public static void main(String[] args) {

		NotificationCreator creator = new EmailNotificationCreator();

		creator.notifyUser("Welcome!");

		creator = new SmsNotificationCreator();
		creator.notifyUser("OTP: 1234");
	}
}
