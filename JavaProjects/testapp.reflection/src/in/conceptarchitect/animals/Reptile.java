package in.conceptarchitect.animals;

public abstract class Reptile extends Animal implements Hunter{

	
	@Override
	public String breed() {
		return getType()+" is egg laying";
	}
	
	@Override
	public String move() {
		return getType()+" crawls";
	}
	
	@Override
	public String eat() {
		return getType()+" flesh eaters";
	}
	
	@SpecialBehavior
	public abstract String hunt();

}
