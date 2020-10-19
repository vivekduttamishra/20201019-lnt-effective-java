
class FactorialApp{
	public static void main(String []args){
		int n=5;
		int fn=factorial(n); //user defined function

		System.out.println("Factorial of "+n+" is "+fn);
	}

	static	int factorial(int x){

		int fx=1;
		while(x>1)
			fx*=x--;

		return fx;
	}
}