package in.conceptarchitect.animals;

public class Eagle extends Bird implements Hunter{

	
	@Override	
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a flesh eater";
	}
	
	public String hunt() {
		return getType()+" is a flying hunter";
	}

	
}
