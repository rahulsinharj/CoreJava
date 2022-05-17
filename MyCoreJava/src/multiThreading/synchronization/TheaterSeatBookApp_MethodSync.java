package multiThreading.synchronization;

class Theature {
	int totalSeats = 10;

	synchronized void bookSeat(int requestedSeats) // This resource is now of type "Synchronized"
	{
		if (totalSeats >= requestedSeats) {
			System.out.println("Congratulations ! " + requestedSeats + " seats booked successfully by "+ Thread.currentThread().getName());
			totalSeats = totalSeats - requestedSeats;
			System.out.println("Seats Left : " + totalSeats);
		} 
		else {
			System.out.println("Sorry ! " + requestedSeats + " seats cannot be booked by " + Thread.currentThread().getName());
			System.out.println("Only " + totalSeats + " Seats Left");
		}
	}
}

class MyThreadd extends Thread {
	Theature b;
	int requestedSeats;

	public MyThreadd(Theature b) {
		super();
		this.b = b;
	}

	public void setRequestedSeats(int requestedSeats) {
		this.requestedSeats = requestedSeats;
	}

	@Override
	public void run() {
		b.bookSeat(requestedSeats);
	}
}

public class TheaterSeatBookApp_MethodSync {

	public static void main(String[] args) {
		Theature b = new Theature();

		MyThreadd threadUser1 = new MyThreadd(b);
		threadUser1.setName("Rahul-Thread");
		threadUser1.setRequestedSeats(7);
		threadUser1.start();

		MyThreadd threadUser2 = new MyThreadd(b);
		threadUser2.setName("Shubham-Thread");
		threadUser2.setRequestedSeats(6);
		threadUser2.start();
	}
}
