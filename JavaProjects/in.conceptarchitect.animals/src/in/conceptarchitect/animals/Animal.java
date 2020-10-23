package in.conceptarchitect.animals;

public abstract class Animal {
	
	//abstract methods
	
	public abstract String eat();
	
	public abstract String breed();
	
	public abstract String move() ;
	
	//an abstract class may have non-abstract concrete implements methods
	
//	public String getType() {
//		//String type=""+ this;   //this.toString()
//		
//		String type=this.toString();
//		
//		int dot=type.lastIndexOf('.');
//		int at=type.indexOf('@');
//		return type.substring(dot+1,at);
//	}
	
	
	public boolean isDomstic() {
		return this instanceof Domestic;
	}
	
	public String getType() {
		return this.toString();
	}
	
	
	public String die() {
		return getType()+" dies";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
	
}
