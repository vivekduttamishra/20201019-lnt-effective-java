package in.conceptarchitect.animals;

public class Snake extends Reptile {

	@Override 
	public String hunt() {
		return getType()+" hunts with poison";
	}
}
