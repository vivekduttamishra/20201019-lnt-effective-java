package testapp.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import in.conceptarchitect.animals.SpecialBehavior;
import in.conceptarchitect.animals.Speciality;
import in.conceptarchitect.utils.CodeBuilder;

public class ReflectionHelper {

	Class cls;
	Object object;

	public ReflectionHelper(Class cls) {		
		this.cls = cls;
	}
	
	public ReflectionHelper(Object obj) {		
		this.object=object;
		this.cls = obj.getClass();		
	}
	
	
	public String getInfo() {
	
		CodeBuilder code=new CodeBuilder();
		
		int mod=cls.getModifiers();
		
		code.append("package %s;",cls.getPackageName())
			.nextLine()
			.nextLine();
		
		
		
			
		if(Modifier.isPublic(mod))
			code.append("public ");
		
		if(Modifier.isInterface(mod))
			code.append("inteface ");
		else {
			if(Modifier.isAbstract(mod))
				code.append("abstract ");
			if(Modifier.isFinal(mod))
				code.append("final ");
			
			code.append("class ");
		}
		
		code
			.append("%s ",cls.getSimpleName())
			.append(" extends %s ", cls.getSuperclass().getName());
		
		Class[] interfaces=cls.getInterfaces();
		if(interfaces.length>0) {
			code.append("implements ");
			for(int i=0;i<interfaces.length;i++) {
				if(i>0)
					code.append(", ");
				
				code.append(" %s",interfaces[i].getName());
			}
			
		}
		
		
		
		code.append(" {")
			.nextLine();
			
		Field [] fields= cls.getDeclaredFields();
		
		code.indent().nextLine().append("//fields").nextLine();
		
		for(Field field : fields)
			code.append("%s %s;", field.getType(),field.getName()).nextLine();
		
			
		code.nextLine().append("//methods").nextLine();
		
		for(Method method : cls.getMethods())
			code.append("%s %s() ;//%s",method.getReturnType().getName(),method.getName(),method.toString())
			.nextLine();
		
			
		code.unindent().nextLine().append("}");
		
		
		
		
		return code.toString();	
		
		
	}
	
	
	public Object getObject() {		
		if(object==null) {
			try {
			Constructor ctor= cls.getConstructors()[0];
			object=ctor.newInstance();
			}catch(Exception ex) {
				throw new  RuntimeException(ex.getMessage(),ex);
			}
		}		
		
		return object;
	}
	
	
	
	public void use() {
		
		Object obj=getObject();
		
		Method [] methods=cls.getMethods(); //we get all public method of the class
		
		for(Method method : methods) {
			
			if(method.getDeclaringClass().equals(Object.class))
				continue; //I don't want to call Object class method
			
			if(method.getParameterCount()>0)
				continue; //I don't want to call parameterized methods
			
			try {
				System.out.print("invoking "+method.getName()+"...");
				Object result = method.invoke(obj); //same as obj.method()
			System.out.println(result);
			System.out.println();
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	public void useSpecialBehavor() {
		
		Object obj=getObject();
		
		Method [] methods=cls.getMethods(); //we get all public method of the class
		int count=0;
		for(Method method : methods) {
			
			if(method.getDeclaringClass().equals(Object.class))
				continue; //I don't want to call Object class method
			
			if(method.getParameterCount()>0)
				continue; //I don't want to call parameterized methods
			
			if(method.getDeclaredAnnotation(SpecialBehavior.class)==null) //not a special behavior
				continue; //ignore
			
			try {
				count++;
				System.out.print("invoking "+method.getName()+"...");
				Object result = method.invoke(obj); //same as obj.method()
			System.out.println(result);
			System.out.println();
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		if(count==0)
			System.out.println(cls.getSimpleName()+" has no special behavior");
		
	}
	
	public void useSpeciality() {
		
		Speciality speciality= (Speciality) cls.getAnnotation(Speciality.class);
		
		if(speciality==null) {
			System.out.println("Sorry "+cls.getSimpleName()+" has no speciality");
			return;
		}
		
		String methodName = speciality.value();
		
		Method method=null;
		try {
			method = cls.getMethod(methodName);
		} catch (NoSuchMethodException e) {
			System.out.println("Sorry "+ cls.getSimpleName()+ " doesn't have special behavior "+methodName);
			return ;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Object obj=getObject();
		
		System.out.println("calling "+methodName+"...");
		try {
			for(int i=0;i<speciality.call();i++) {
				Object result= method.invoke(obj);
				
				System.out.println(result);			
				
			}
		} catch(Exception ex) {
			System.out.println("error invoking speciality "+methodName);
		}
			
		
	}
	
}
