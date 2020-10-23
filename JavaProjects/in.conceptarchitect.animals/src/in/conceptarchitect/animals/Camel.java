package in.conceptarchitect.animals;

public class Camel extends Mammal{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a grass eater";
	}
	
	public String ride() {
		return getType()+" is a great desert ride";
	}

}
