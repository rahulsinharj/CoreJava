package multiThreading.interThread;

import java.util.Arrays;

class OddEvenInsertWork
{
	int[] arr = new int[10];
	boolean evenDone = false;

	synchronized public void insertEven()
	{
		int evenIndex = 0;
		while (evenIndex < arr.length) 
		{
			if (evenDone) 
			{
				try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
			}
			else 
			{
				arr[evenIndex] = 2;
				evenIndex += 2;

				evenDone = true;
				notify();
			}
		}
	}
	
	synchronized public void insertOdd()
	{
		int oddIndex = 1;
		while (oddIndex < arr.length) 
		{
			if (!evenDone) 		// if even not done, then it will wait for ODD to get him done first.
			{
				try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
			}
			else 
			{
				arr[oddIndex] = 1;
				oddIndex += 2;

				evenDone = false;
				notify();
			}
		}
	}
}


public class PrintOddEven {

	public static void main(String[] args) {

		OddEvenInsertWork obj = new OddEvenInsertWork();
		
		Thread th1 = new Thread(() -> {
	
			obj.insertEven();
		});

		Thread th2 = new Thread(() -> {
	
			obj.insertOdd();
		});

		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(obj.arr));
	}

	

}
