package demo12.sharedresources;

public class Simulation {
	
	public static long simulate(String name,int workerCount, int workPerWorker, boolean useSamBasket) {
		
		System.out.println("starting "+name);
		Worker [] workers= new Worker[workerCount];
		Basket singleBasket=new Basket();
		
		for(int i=0;i<workerCount;i++) {
			
			Basket basket= useSamBasket? singleBasket : new Basket();			
			Worker worker=new Worker(basket, workPerWorker);		
			workers[i]=worker;
		}
		
		//start all worker
		long start=System.currentTimeMillis();
		for(Worker worker: workers) {
			worker.start();
		}
		System.out.println("please wait for worker to finish");
		//wait for workers to finish
		for(Worker worker:workers) {
			worker.join();
		}
		
		long totalWorksDone=0;
		if(useSamBasket) {
			totalWorksDone= singleBasket.getItems();
		} else {
		
		
		for(Worker worker: workers)
			totalWorksDone+=worker.basket.getItems();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("finished "+name+ " in "+(end-start)+" ms\tTotal added is "+totalWorksDone);
		
		
		return totalWorksDone;
		
	}

}
