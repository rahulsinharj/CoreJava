package multiThreading.synchronization;

class MyTheature
{
	static int totalSeat = 20;										// STATIC resource	
	
	static synchronized void bookSeat(int requestedSeats)			// This resource is now of type "STATIC Synchronized"
	{
		if(totalSeat >= requestedSeats) {
			System.out.println("Congratulations ! " +requestedSeats+" seats booked successfully by "+Thread.currentThread().getName());
			totalSeat = totalSeat - requestedSeats;
			System.out.println("Seats Left : "+totalSeat);
		}
		else {
			System.out.println("Sorry ! " +requestedSeats+ " seats cannot be booked by "+Thread.currentThread().getName());
			System.out.println("Only "+totalSeat +" Seats Left");
		}
	}
}

class MyThread extends Thread {
	MyTheature b;
	int requestedSeats;

	public MyThread(MyTheature b) {
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

public class TheaterSeatBookApp_StaticSync {

	public static void main(String[] args) {
		MyTheature b1 = new MyTheature();

		MyThread threadUser1 = new MyThread(b1);		
		threadUser1.setName("Rahul-Thread");
		threadUser1.setRequestedSeats(7);
		threadUser1.start();

		MyThread threadUser2 = new MyThread(b1);			// Yaha instead of creating multiple thread by AnonymousClass threadObj, yaha ek hi "MyThread" class ko create kiya hai hamne , kyuki each Thread ko ek hi kaam karna tha isliye ek hi run method rakhe , 
		threadUser2.setName("Shubham-Thread");					// taaki MyThread class ka hi multiple threadObj create karke sab usi same run method ko hi use kare. 
		threadUser2.setRequestedSeats(6);
		threadUser2.start();
		
	//------------------------
		
		MyTheature b2 = new MyTheature();			// If we multiple object of our "resource" then again we will be facing problem of data consistency. 

		MyThread threadUser3 = new MyThread(b2);
		threadUser3.setName("Vikash-Thread");
		threadUser3.setRequestedSeats(5);
		threadUser3.start();

		MyThread threadUser4 = new MyThread(b2);
		threadUser4.setName("Shashank-Thread");
		threadUser4.setRequestedSeats(6);
		threadUser4.start();
	}
}
