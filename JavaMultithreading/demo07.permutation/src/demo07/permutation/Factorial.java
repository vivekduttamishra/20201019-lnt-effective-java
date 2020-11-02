package demo07.permutation;

public class Factorial {

	public static int calculate(int n) {
		
		int fn=1;
		
		while(n>=1) {
			
			ThreadUtils.sleep(1000);
			fn*=n--;
		}
		
		return fn;
	}

}
