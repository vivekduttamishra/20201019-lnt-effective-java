package in.conceptarchitect.animals;

public class Animal {

	
	public String getType() {
		String type=""+ this;
		int dot=type.lastIndexOf('.');
		int at=type.indexOf('@');
		return type.substring(dot+1,at);
	}
	
	public String eat() {
		return getType()+" eats something";
	}
	
	public String breed() {
		return getType()+" breeds somehow";
	}
	
	public String move() {
		return getType()+" moves somehow";
	}
	
	public String die() {
		return getType()+" dies";
	}
}
