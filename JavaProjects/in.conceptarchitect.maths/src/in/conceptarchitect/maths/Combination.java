package in.conceptarchitect.maths;

public class Combination {
	public int calculate(int n,int r) {
		Factorial fact=new Factorial(); 
		return fact.calculate(n)/fact.calculate(n-r)/fact.calculate(r);
	}

}
