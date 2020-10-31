package in.conceptarchitect.animals;



@Speciality(value="humanSpeak",call=3)
public class Parrot extends Bird implements Domestic {

	
	@Override
	
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a fruitarian";
	}
	
	@SpecialBehavior
	public String humanSpeak() {
		return getType()+" can speak in human voice";
	}
}
