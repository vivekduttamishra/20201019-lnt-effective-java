package demo12.sharedresources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorkerBasketDemoTests {

	@Test
	public void workerReturnsCorrectResultIfTheyUseDifferentBaskets() {
		
		int workerCount=100;
		int workPerWorker=100;
		
		long totalWorkDone= Simulation.simulate("100x100 different basket", workerCount, workPerWorker, false); //each worker will use their own basket
		
		assertEquals(workerCount*workPerWorker, totalWorkDone);
		
		
	}

	
	@Test
	public void largeNumberOfWorkerReturnsCorrectResultIfTheyUseDifferentBaskets() {
		
		int workerCount=10000;
		int workPerWorker=100000;
		
		long totalWorkDone= Simulation.simulate("10Kx10K different basket", workerCount, workPerWorker, false); //each worker will use their own basket
		
		assertEquals(workerCount*workPerWorker, totalWorkDone);
		
		
	}
	
	@Test
	public void largeNumberOfWorkerReturnsCorrectResultIfTheyUseSameBaskets() {
		
		int workerCount=10000;
		int workPerWorker=100000;
		
		long totalWorkDone= Simulation.simulate("10Kx10K same basket", workerCount, workPerWorker, true); //each worker will use their own basket
		
		assertEquals(workerCount*workPerWorker, totalWorkDone);
		
		
	}
	
	
	
	
	
	
	
}
