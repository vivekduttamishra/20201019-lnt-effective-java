package in.conceptarchitect.animals;

public class Bird extends Animal{

	
	@Override
	public String breed() {
		return getType()+" is egg laying";
	}
	
	public String fly() {
		return getType()+ "fly in sky";
	}
	
	
	

}
