package in.conceptarchitect.maths;

public class Factorial {
	
	public int calculate(int x) {
		int fx=1;
		while(x>1)
			fx*=x--;
		return fx;
	}

}
