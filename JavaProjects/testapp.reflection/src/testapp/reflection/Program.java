package testapp.reflection;

import in.conceptarchitect.animals.Tiger;
import in.conceptarchitect.utils.Input;

public class Program {
	public static void main(String []args) throws ClassNotFoundException {
		
				
		//testClass1();
		Input in=new Input();
		String className= in.readString("Class Name?");
		
		if(!className.contains("."))
			className="in.conceptarchitect.animals."+className;
		
		Class cls=Class.forName(className);
		
		ReflectionHelper helper=new ReflectionHelper(cls);
		//System.out.println(helper.getInfo());
		
		//helper.use();
		
		//helper.useSpecialBehavor();
		
		helper.useSpeciality();
		
	}

	private static void testClass1() throws ClassNotFoundException {
		Tiger tiger=new Tiger();		
		Class cls1= Tiger.class;	//from Class
		Class cls2=tiger.getClass(); //from Object
		Class cls=Class.forName("in.conceptarchitect.animals.Tiger"); //from a name string
		
		System.out.println(cls1.hashCode());
		System.out.println(cls2.hashCode());
		System.out.println(cls.hashCode());
		
		
		
		ReflectionHelper helper=new ReflectionHelper(cls);
		System.out.println(helper.getInfo());
	}
}
