package in.conceptarchitect.social;

public class Person {

	protected String name;
	private String email;
	private	String phone;
			
	public Person(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	}

	
	public void show() {
		System.out.println("Name:\t"+name);
		System.out.println("Email:\t"+email);
		System.out.println("Phone:\t"+phone);
	}
	
	public void work() {
		System.out.println(name+" has no active work");
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
	
	
	

	
}
