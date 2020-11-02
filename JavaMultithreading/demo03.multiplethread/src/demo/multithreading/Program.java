package demo.multithreading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountDownTask task1=new CountDownTask();
		CountDownTask task2=new CountDownTask();
		CountDownTask task3=new CountDownTask();
		
		Thread thread1=new Thread(task1); 
		Thread thread2=new Thread(task2);
		Thread thread3=new Thread(task3);
		
		thread1.start(); //it will start a new Thread and call printer.run()
		thread2.start();
		thread3.start();
		
		
		
		
		
	}

}
