package in.conceptarchitect.animals;

public abstract class Mammal extends Animal{

	
	@Override
	public String breed() {
		return getType()+" is child bearing";
	}
	
	@Override
	public String move() {
		return getType()+" moves on ground";
	}
	

}
