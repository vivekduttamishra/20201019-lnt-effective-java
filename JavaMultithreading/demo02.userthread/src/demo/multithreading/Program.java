package demo.multithreading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InfoPrinter printer=new InfoPrinter();
		
		Thread userThread=new Thread(printer,"User Thread"); 
		
		userThread.start(); //it will start a new Thread and call printer.run()
		
		
		printer.run(); //it will run on the current thread
		
		
	}

}
