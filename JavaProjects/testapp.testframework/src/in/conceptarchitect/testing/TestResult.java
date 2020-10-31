package in.conceptarchitect.testing;

import java.lang.reflect.Method;
import java.util.HashMap;



public class TestResult {
	
	HashMap<Method,Throwable> results=new HashMap<>();
	int failed=0;
	int tested=0;
	int errors=0;
	int passed=0;
	
	public void add(Method method, Throwable error) {
		results.put(method,error);
		tested++;
		if(error!=null) {
			if(error instanceof AssertionError)
				failed++;
			else
				errors++;
		} else {
			passed++;
		}
	}
	
	public boolean isSuccess() {
		return passed==tested;
	}
	
	
	public void printReport() {
		
		if(isSuccess())
			System.out.println("All Test Passed");
		else {
			
			for(Method method : results.keySet()) {
				
				System.out.print(method.getName()+"...");
				Throwable t= results.get(method);
				if(t==null) {
					System.out.println("PASSED");
				} else if( t instanceof AssertionError) {
					System.out.println( "FAILED");
					System.out.println("\t"+t.getMessage());
				} else {
					System.out.println("ERROR");
					t.printStackTrace();
				}
				
			}
			
			System.out.println("Total Tests "+tested);
			System.out.println("Total Passed "+passed);
			System.out.println("Total Failed "+failed);
			System.out.println("Total Errors "+errors);
			
			
		}
		
		
		
		
	}
	

}
