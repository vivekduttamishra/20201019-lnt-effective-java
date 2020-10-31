package in.conceptarchitect.testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestRunner {
	
	Class cls;
	
	List<Method> testMethods=new ArrayList<>();
	Method before;
	
	public TestRunner(Class cls) {
		this.cls=cls;
		
		for(Method method : cls.getMethods()) {
			
			if(method.getDeclaringClass().equals(Object.class))
				continue;
			
			if(method.getParameterCount()>0)
				continue;
			
			if(method.getDeclaredAnnotation(Test.class)!=null)
				testMethods.add(method);
			else if(before==null && method.getDeclaredAnnotation(Before.class)!=null)
				before=method;
			
		}
		
	}
	
	public TestResult run() {
		
		TestResult result=new TestResult();
		
		
		for(Method method : testMethods) {
			
			try {
				Object testObject= cls.newInstance();
				if(before!=null)
					before.invoke(testObject); //call before
					method.invoke(testObject); //call test
					result.add(method, null) ; //successful test					
				
			}
			
			catch(InvocationTargetException ex) {
				result.add(method,ex.getCause());
				
			} catch(Exception ex) {
				
			}
			
			
		}
		
		
		
		return result;
		
		
	}
	
	
	
	

}
