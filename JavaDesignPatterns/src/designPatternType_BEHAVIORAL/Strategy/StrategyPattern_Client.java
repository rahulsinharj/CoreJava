package designPatternType_BEHAVIORAL.Strategy;

//🎯 Scenario: Payment Processing System
//Step 1: Strategy Interface
interface PaymentStrategy {
	void pay(double amount);
}

//Step 2: Concrete Strategies
class CreditCardPaymentStrategy implements PaymentStrategy {

	private final String cardNumber;

	public CreditCardPaymentStrategy(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
	}
}

class UpiPaymentStrategy implements PaymentStrategy {

	private final String upiId;

	public UpiPaymentStrategy(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
	}
}

class NetBankingPaymentStrategy implements PaymentStrategy {

	private final String bankName;

	public NetBankingPaymentStrategy(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using NetBanking via " + bankName);
	}
}

//Step 3: Context Class (MOST IMPORTANT)
class PaymentContext {

	private PaymentStrategy paymentStrategy;

	public PaymentContext(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void executePayment(double amount) {
		paymentStrategy.pay(amount);
	}
}

//Context is stable, strategies vary.
//Step 4: Client Usage
public class StrategyPattern_Client {// PaymentClient

	public static void main(String[] args) {

		PaymentContext context = new PaymentContext(new CreditCardPaymentStrategy("1234-5678"));

		context.executePayment(1000);

		// Runtime behavior change
		context.setPaymentStrategy(new UpiPaymentStrategy("rahul@upi"));
		context.executePayment(500);

		// Runtime behavior change
		context.setPaymentStrategy(new NetBankingPaymentStrategy("SBI-Bank"));
		context.executePayment(800);
	}
}
