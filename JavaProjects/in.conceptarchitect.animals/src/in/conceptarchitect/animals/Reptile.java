package in.conceptarchitect.animals;

public class Reptile extends Animal{

	
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
	
	public String hunt() {
		return getType()+" hutns its pray somehow";
	}

}
