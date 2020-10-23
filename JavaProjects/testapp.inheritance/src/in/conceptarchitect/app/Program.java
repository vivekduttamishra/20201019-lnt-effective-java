package in.conceptarchitect.app;

import in.conceptarchitect.social.Person;
import in.conceptarchitect.social.Student;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student=new Student("Shivanshi","shivanshi@gmail.com","99393939","501","PG","Java","Cloud");			
		
		//System.out.println(student.name);

		checkPerson(student); //check student as Person
		
		Person vivek=new Person("Vivek","vivek@gmail.com","1111222333");
		checkPerson(vivek);
		
	}
	
	private static void checkPerson(Person person) {
		person.show();
		person.work();
	}
	
	private static void testStudentsNewMethods(Student student) {
		System.out.println(student.getGrade());
		
		String checkSubjects[]= {"Java","C#", "AI", "Cloud" };
		
		for(String subject : checkSubjects) {
			System.out.println(student.getName()+" studies "+ subject+ " : "+student.studies(subject));
		}
	}

	

}
