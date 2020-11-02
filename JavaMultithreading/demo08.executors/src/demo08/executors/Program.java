package demo08.executors;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executor= Executors.newFixedThreadPool(4); //I have a threadpool of 4 threads.
		
		for(int i=1;i<=20;i++) {  //4threas will run 20 tasks			
			final int id=i;
			executor.execute(()-> task(id));			
		}

		System.out.println("waiting for tasks to finish...");
		
		executor.shutdown(); //I will accept no new jobs
		
		//I will wait for current job to terminated for a maximum of 1 Hour
		//this is virtually as long as it takes
		//If thread is taking longer than an hour, we move on
		executor.awaitTermination(1,TimeUnit.HOURS); 
		
		System.out.println("All tasks finished.");
		
	}
	
	static Random random=new Random();
	
	static void task(int id) {
		int sleep=(random.nextInt(5)+1) ;
		ThreadUtils.println("Task id %d working for %s seconds", id,sleep);
		ThreadUtils.sleep(sleep*1000);
		ThreadUtils.println("Task id %d finished", id);		
	}

}
