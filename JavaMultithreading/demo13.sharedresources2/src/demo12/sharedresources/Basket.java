package demo12.sharedresources;

public class Basket {
	
	long items;
	public void add() {
		
		synchronized(this){
			
			long x=items;			
			x++;			
			items=x;
		}
	}
	public long getItems() {
		return items;
	}
	
	

}
