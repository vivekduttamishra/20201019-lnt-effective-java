package demo.multithreading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread thread1=new Thread(()-> countDown(200)); 
		
		Thread thread2=new Thread(()-> countDown(150));   //lambda expression
		
		Thread thread3=new Thread(Program::quickCountDown); //function reference
		
		thread1.start(); //task is thread
		thread2.start();
		thread3.start();
		
		
		System.out.println("Program ends");
		
		
		
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
