package in.conceptarchitect.animals;

public class Horse extends Mammal implements Domestic, Rideable{
	
	int speed;
	int age;
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a grass eater";
	}
	
	public String ride() {
		return getType()+" is a great ride";
	}

}
