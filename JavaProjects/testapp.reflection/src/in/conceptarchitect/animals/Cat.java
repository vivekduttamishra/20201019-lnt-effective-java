package in.conceptarchitect.animals;

public abstract class Cat extends Mammal implements Hunter{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a flesh eater";
	}
	
	
	@SpecialBehavior
	public String hunt() {
		return getType()+" is great hunter";
	}

}
