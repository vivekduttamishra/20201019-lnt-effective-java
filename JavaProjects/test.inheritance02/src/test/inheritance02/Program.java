package test.inheritance02;

import in.conceptarchitect.animals.Animal;
import in.conceptarchitect.animals.Bird;
import in.conceptarchitect.animals.Camel;
import in.conceptarchitect.animals.Cat;
import in.conceptarchitect.animals.Cow;
import in.conceptarchitect.animals.Crocodile;
import in.conceptarchitect.animals.Dog;
import in.conceptarchitect.animals.Eagle;
import in.conceptarchitect.animals.Horse;
import in.conceptarchitect.animals.Leopard;
import in.conceptarchitect.animals.Mammal;
import in.conceptarchitect.animals.Parrot;
import in.conceptarchitect.animals.Reptile;
import in.conceptarchitect.animals.Snake;
import in.conceptarchitect.animals.Tiger;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal [] animals= {
				//I can put any animal
				new Tiger(),
				new Horse(),
				new Animal(),
				new Camel(),
				new Crocodile(),
				new Parrot(),
				new Dog(),
				new Cat(),
				new Cow(),
				new Leopard(),
				new Mammal(),
				new Eagle(),
				new Reptile(),
				new Snake(),
				new Bird()
		};
		
		
		for(Animal animal : animals) {
			System.out.println("Animal is "+animal.getType());
			
			System.out.println(animal.breed());
			System.out.println(animal.move());
			System.out.println(animal.eat());
			System.out.println();
		}

	}

}
