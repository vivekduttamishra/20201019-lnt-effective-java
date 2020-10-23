package in.conceptarchitect.animals;

public class Dog extends Mammal{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a flesh eater";
	}
	
	public String guard() {
		return getType()+" can guard the house";
	}
	
	public String hunt() {
		return getType()+" gurads our house";
	}

}
