package in.conceptarchitect.social;

public class Student extends Person{

	String grade;
	String [] subjects;
	private String enrollmentNumber;
	
	public Student(String name, String email, String phone,String enrollmentNumber, String grade, String ...subjects) {
		super(name, email, phone);
				
		// TODO Student class initalizations
		this.grade=grade;
		this.subjects=subjects;
		this.enrollmentNumber=enrollmentNumber;
		
		
	}

	
	@Override	
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Enrollemnt Number:\t"+enrollmentNumber);
		super.show();
		System.out.println("Grade:\t"+grade);
		System.out.print("Subjects:\t");
		for(String subject: subjects) {
			System.out.print(subject+"\t");
		}
		System.out.println();
	}
	
	
	
	
	
	public String getGrade() {
		return grade;
	}

	@Override    //we are overriding work from Person
	public void work() {		
		System.out.println(this.name+" studies in "+grade+"\ttotal subjects: "+subjects.length);
	}
	
	
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String[] getSubjects() {
		return subjects;
	}
	
	public boolean studies(String subject) {
		for(String currentSubject : subjects) {
			if(currentSubject.equalsIgnoreCase(subject))
				return true;
		}
		
		return false;
	}
	
}
