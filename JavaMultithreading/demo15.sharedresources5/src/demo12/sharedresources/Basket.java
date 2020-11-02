package demo12.sharedresources;

import java.util.concurrent.locks.Lock;

public class Basket {
	
	long items;
	Lock lock=new java.util.concurrent.locks.ReentrantLock();
	
	
	
	
	public Lock getLock() {
		return lock;
		
	}
	
	
	public void add() {
		
			
			long x=items;			
			x++;			
			items=x;
		
	}
	public long getItems() {
		return items;
	}
	
	

}
