package in.conceptarchitect.animals;

public class Dog extends Mammal implements Domestic,Hunter{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a flesh eater";
	}
	
	public String hunt() {
		return getType()+" hunts its pray";
	}
	
	public String guard() {
		return getType()+" gurads our house";
	}

}
