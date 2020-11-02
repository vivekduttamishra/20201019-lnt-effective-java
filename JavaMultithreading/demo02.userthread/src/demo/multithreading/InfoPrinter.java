package demo.multithreading;

public class InfoPrinter implements Runnable {

	@Override
	public void run() {
		Thread ct=Thread.currentThread();
		System.out.println("The Current Thread # "+ct.getId()
							+" has name "+ct.getName());

	}

}
