package demo.multithreading;

public class CountDownTask extends Thread {
	
	int max;
	
	public CountDownTask(int max) {
		super();
		this.max = max;
	}

	@Override
	public void run() {
		
		ThreadUtils.println("Started");
	
		while(max>0) {
			ThreadUtils.println("counts %d", max);
			max--;
		}
		
		ThreadUtils.println("ends");

	}

}
