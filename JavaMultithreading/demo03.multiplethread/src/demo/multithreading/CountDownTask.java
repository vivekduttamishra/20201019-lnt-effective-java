package demo.multithreading;

public class CountDownTask implements Runnable {

	@Override
	public void run() {
		int max=10;
		
		ThreadUtils.println("Started");
	
		while(max>0) {
			ThreadUtils.println("counts %d", max);
			max--;
		}
		
		ThreadUtils.println("ends");

	}

}
