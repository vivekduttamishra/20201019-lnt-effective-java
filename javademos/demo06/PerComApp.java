
class PermutationCombinationApp{

	public static void main(String []args){
		int n=5;
		int r=3;

		int p=Permutation.calculate(n,r);
		int c=Combination.calculate(n,r);

		ConsoleWriter writer=new ConsoleWriter();

		writer.writeLine(n+"P"+r+"=\t"+p);
		writer.writeLine(n+"C"+r+"=\t"+c);


	}

}