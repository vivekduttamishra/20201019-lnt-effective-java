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
		
		ThreadUtils.sleep(6000);
		
		//4 jobs must have finished
		//4 new jobs must have started
		//12 jobs are currently pending
		
		
		executor.shutdown(); //I will accept no new jobs
		
		try {
			System.out.println("Adding a new job to executor that has been shutdown");
			executor.execute(()->System.out.println("This job wont be executing"));
			System.out.println("This is not possible!!!");
		} catch(Exception ex) {
			System.out.println("can't execute this job. error is :"+ex.getClass().getName());
		}
		
		
		executor.awaitTermination(1,TimeUnit.HOURS); 
		
		System.out.println("After the completion of all jobs -- counter is "+count);
		
		System.out.println("All tasks finished.");
		
	}
	
	static Random random=new Random();
	static int count=0;
	static void task(int id) {
		int sleep=5; //5 seconds
		ThreadUtils.println("Task id %d working for %s seconds", id,sleep);
		ThreadUtils.sleep(sleep*1000);
		count++;
		ThreadUtils.println("Task id %d finished", id);		
	}

}
