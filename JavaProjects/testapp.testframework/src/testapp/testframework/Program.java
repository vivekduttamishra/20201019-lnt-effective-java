package testapp.testframework;

import in.conceptarchitect.collections.IndexedListSearchSpecs;
import in.conceptarchitect.testing.TestResult;
import in.conceptarchitect.testing.TestRunner;

public class Program {

	public static void main(String[] args) {
		
		TestRunner runner=new TestRunner(IndexedListSearchSpecs.class);
		
		TestResult result=runner.run();
		
		result.printReport();
	}

}
