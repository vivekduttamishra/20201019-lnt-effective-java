package test.inheritance02;

import in.conceptarchitect.animals.Animal;
import in.conceptarchitect.animals.Camel;
import in.conceptarchitect.animals.Cow;
import in.conceptarchitect.animals.Crocodile;
import in.conceptarchitect.animals.Dog;
import in.conceptarchitect.animals.Eagle;
import in.conceptarchitect.animals.Horse;
import in.conceptarchitect.animals.Hunter;
import in.conceptarchitect.animals.Leopard;
import in.conceptarchitect.animals.Parrot;
import in.conceptarchitect.animals.Rideable;
import in.conceptarchitect.animals.Snake;
import in.conceptarchitect.animals.Tiger;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal [] animals= {
				//I can put any animal
				new Tiger(),
				new Horse(),
				//new Animal(), //you are not allowed to create an object of the abstract class
				new Camel(),
				new Crocodile(),
				new Parrot(),
				new Dog(),
				//new Cat(),
				new Cow(),
				new Leopard(),
				//new Mammal(),
				new Eagle(),
				//new Reptile(),
				new Snake()
				//new Bird()
		};
		
		
		for(Animal animal : animals) {
			if(animal.isDomstic())
				System.out.print("Domestic ");
			
			System.out.println("Animal is "+animal);  //calling animal.toString()
			
			System.out.println(animal.breed());
			System.out.println(animal.move());
			System.out.println(animal.eat());
			
			//System.out.println(animal.hunt()); //animal does't have a hunt()
			
			//Tiger tiger= animal;   //not sure if animal is tiger
			//huntIfYourAreATiger(animal);
			
			if(animal instanceof Hunter) {
				Hunter hunter=(Hunter)animal;
				System.out.println(hunter.hunt());
			}
			
			if(animal instanceof Rideable) {
				Rideable rideable=(Rideable) animal;
				System.out.println(rideable.ride());
			}
			
			
			System.out.println();
		}

	}

	private static void huntIfYourAreATiger(Animal animal) {
		if(animal instanceof Tiger) {
			Tiger tiger=(Tiger) animal;			
			System.out.println(tiger.hunt());
		}
	}

}
