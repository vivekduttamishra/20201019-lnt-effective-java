package in.conceptarchitect.animals;

public abstract class Bird extends Animal{

	
	@Override
	public String breed() {
		return getType()+" is egg laying";
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return fly();
	}
	
	public String fly() {
		return getType()+ "fly in sky";
	}
	
	
	

}
