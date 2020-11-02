package demo11.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		final int n=8;
		final int r=3;
		
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		Future<Integer> fn= executor.submit(()->factorial(n));
		
		Future<Integer> fn_r= (Future<Integer>) executor.submit(()->factorial(n-r));
		
		System.out.print("waiting for factorials");
		long start=System.currentTimeMillis();
		
		while(!(fn.isDone() && fn_r.isDone())) {
			System.out.print(".");
			ThreadUtils.sleep(200);
		}
				
		
		
		int p= fn.get()/fn_r.get(); //get waits for result to be ready
		
		long end=System.currentTimeMillis();
		System.out.println();
		System.out.println("Permutation is "+p);
		System.out.println("Total time taken is "+(end-start));
		
		
		
		
		
		
		
		//
		

	}
	
	static int factorial(int n) {
		int fn=1;
		
		while(n>=1) {
			
			ThreadUtils.sleep(1000);
			fn*=n--;
		}
		
		return fn;
		
	}

}
