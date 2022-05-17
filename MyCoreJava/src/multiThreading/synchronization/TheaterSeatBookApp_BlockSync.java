package multiThreading.synchronization;

class Theatere
{
	int totalSeats = 10;
	
	void bookSeat(int requestedSeats)			// This resource is now of type "Synchronized"
	{
		System.out.println("1) Current thread : "+Thread.currentThread().getName());
		System.out.println("2) Current thread : "+Thread.currentThread().getName());
		System.out.println("3) Current thread : "+Thread.currentThread().getName());
		System.out.println("4) Current thread : "+Thread.currentThread().getName());
		
		synchronized (this) 			// Using Synchronized Block - in place of synchronized method
		{
			if(totalSeats >= requestedSeats) {
				System.out.println("Congratulations ! " +requestedSeats+" seats booked successfully by "+Thread.currentThread().getName());
				totalSeats = totalSeats - requestedSeats;
				System.out.println("Seats Left : "+totalSeats);
			}
			else {
				System.out.println("Sorry ! " +requestedSeats+ " seats cannot be booked by "+Thread.currentThread().getName());
				System.out.println("Only "+totalSeats +" Seats Left");
			}
		}
		
		System.out.println("5) Current thread : "+Thread.currentThread().getName());
		System.out.println("6) Current thread : "+Thread.currentThread().getName());
		System.out.println("7) Current thread : "+Thread.currentThread().getName());
		System.out.println("8) Current thread : "+Thread.currentThread().getName());

	}
}

public class TheaterSeatBookApp_BlockSync extends Thread {

	static Theatere b;
	int requestedSeats;

	public void setRequestedSeats(int requestedSeats) {
		this.requestedSeats = requestedSeats;
	}

	public void run()
	{
		b.bookSeat(requestedSeats);
	}
	
	public static void main(String[] args) {
	
		b = new Theatere();
		
		TheaterSeatBookApp_BlockSync user1 = new TheaterSeatBookApp_BlockSync();
		user1.setName("Rahul-Thread");
		user1.setRequestedSeats(7);
		user1.start();
		
		TheaterSeatBookApp_BlockSync user2 = new TheaterSeatBookApp_BlockSync();
		user2.setName("Shubham-Thread");
		user2.setRequestedSeats(6);
		user2.start();
	}
}
