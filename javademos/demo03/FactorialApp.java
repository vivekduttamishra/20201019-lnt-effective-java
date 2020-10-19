
class FactorialApp{
	public static void main(String []args){
		int n=5;
		int fn=Factorial.calculate(n); 

		System.out.println("Factorial of "+n+" is "+fn);
	}

}

class Factorial{

	static	int calculate(int x){

		int fx=1;
		while(x>1)
			fx*=x--;

		return fx;
	}
}