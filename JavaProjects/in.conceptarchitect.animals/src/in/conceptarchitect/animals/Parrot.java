package in.conceptarchitect.animals;

public class Parrot extends Bird implements Domestic {

	
	@Override
	
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a fruitarian";
	}
}
