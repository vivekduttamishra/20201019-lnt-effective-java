package in.conceptarchitect.application;

import in.conceptarchitect.maths.Combination;
import in.conceptarchitect.maths.Permutation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int r=3;
		Permutation per=new Permutation();
		Combination com=new Combination();
		
		int p=per.calculate(n, r);
		int c=com.calculate(n, r);
		
		System.out.println("permutation is "+p);
		System.out.println("combination is "+c);
		
		
		
	}

}
