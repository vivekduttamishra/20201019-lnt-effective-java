package in.conceptarchitect.animals;

public class Cat extends Mammal{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a flesh eater";
	}
	
	
	
	public String hunt() {
		return getType()+" gurads our house";
	}

}
