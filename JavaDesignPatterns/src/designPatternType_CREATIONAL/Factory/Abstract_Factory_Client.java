package designPatternType_CREATIONAL.Factory;

/*
//Step 1: Product interfaces
interface Notification {
	void send(String message);
}
*/
interface Logger {
	void log(String message);
}

//Step 2: AWS product family
class AwsNotification implements Notification {
	public void send(String message) {
		System.out.println("AWS Notification: " + message);
	}
}

class AwsLogger implements Logger {
	public void log(String message) {
		System.out.println("AWS Log: " + message);
	}
}

//Step 3: Azure product family
class AzureNotification implements Notification {
	public void send(String message) {
		System.out.println("Azure Notification: " + message);
	}
}

class AzureLogger implements Logger {
	public void log(String message) {
		System.out.println("Azure Log: " + message);
	}
}

//Step 4: Abstract Factory interface
interface CloudFactory {
	Notification createNotification();

	Logger createLogger();
}

//📌 Key idea: factory creates multiple related objects
//Step 5: Concrete factories
class AwsCloudFactory implements CloudFactory {

	public Notification createNotification() {
		return new AwsNotification();
	}

	public Logger createLogger() {
		return new AwsLogger();
	}
}

class AzureCloudFactory implements CloudFactory {

	public Notification createNotification() {
		return new AzureNotification();
	}

	public Logger createLogger() {
		return new AzureLogger();
	}
}

//Step 6: Client
public class Abstract_Factory_Client {

	public static void main(String[] args) {

		CloudFactory factory = new AwsCloudFactory();

		Notification notification = factory.createNotification();
		Logger logger = factory.createLogger();

		notification.send("Deployment successful");
		logger.log("System running");
	}
}
