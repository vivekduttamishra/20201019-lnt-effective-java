package demo.multithreading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread thread1=new Thread(()-> countDown(200)); 
		
		Thread thread2=new Thread(()-> countDown(150));   
		
		Thread thread3=new Thread(()->countDown(2000)); 
		
		//I want to mark my thread3 as daemon thread. 
		
		thread3.setDaemon(true);
		
		//program ends when all non-daemon threads ends. 
		//When non-dameon threads ends daemon threads are killed.
		
		thread1.start(); //task is thread
		thread2.start();
		thread3.start();
		
		
		
		ThreadUtils.waitAll(thread1,thread2); //wait for non-daemon threads
		
		//all critical works are over, non-critals once will be killed.
		
		
		//This line must be the last line of the ouput
		System.out.println("Program ends");
		
		
		
	}

	private static void waitForJoin(Thread thread1, Thread thread2, Thread thread3) {
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		}catch(InterruptedException ex) {
			
		}
	}

	private static void checkIsAliveTest(Thread thread1, Thread thread2, Thread thread3) {
		while(thread1.isAlive() || thread2.isAlive()||thread3.isAlive()) {
			System.out.print("+");
			ThreadUtils.sleep(10); //wait 200 ms before checking again
		}
	}

	private static void sleepyMain() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("This exception will never occur as I am not calling interrupt");
			e.printStackTrace();
		}
	}

	private static void busyMain() {
		//other threads are collectively counting 450 number
		// let main count a larger value > x10
		for(int i=0; i<10000; i++) 
			System.out.print(".");
	}
	
	public static void countDown(int max) {
		
		ThreadUtils.println("Started");
	
		while(max>0) {
			ThreadUtils.println("counts %d", max);
			max--;
		}
		
		ThreadUtils.println("ends");
	}
	
	public static void quickCountDown() {
		countDown(100);
	}

}
