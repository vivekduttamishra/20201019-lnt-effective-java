
class FactorialApp{
	public static void main(String []args){
		int n=5;
		
		//step#1:get object of the class
		Factorial fact=new Factorial(); 

		//step#2: call method using the object
		int fn=fact.calculate(n); 

		System.out.println("Factorial of "+n+" is "+fn);
	}

}

class Factorial{

	int calculate(int x){

		int fx=1;
		while(x>1)
			fx*=x--;

		return fx;
	}
}