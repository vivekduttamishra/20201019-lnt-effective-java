package demo12.sharedresources;

public class Worker implements Runnable{
	
	Basket basket;
	long workCount;
	Thread thread;
	public Worker(Basket basket, long workCount) {
		super();
		this.basket = basket;
		this.workCount = workCount;
		
		thread=new Thread(this);
		
	}
	
	public void start() {
		thread.start();
	}
	
	public void join() {
		try{thread.join();}catch(InterruptedException ex) {}
	}
	
	
	
	public void run() {
		
		for(long i=0;i<workCount;i++) {
			
			synchronized(basket){
				
				basket.add();
				
			}			
		
		}		
	}

}
