package demo12.sharedresources;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Simulation.simulate("Different Basket", 10000, 10000, false);

		System.out.println();
		
		Simulation.simulate("Different Basket", 10000, 10000, true);
	}

}
