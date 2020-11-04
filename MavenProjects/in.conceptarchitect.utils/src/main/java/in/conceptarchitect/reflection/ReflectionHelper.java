package in.conceptarchitect.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {

	public static <T> void set(Object obj, String property, T value) {
		
		try {
			
			//covert name property to getName()
			String methodName= String.format("set%s%s",Character.toUpperCase(property.charAt(0)), property.substring(1));
			Class cls=obj.getClass();
			
			Method method=cls.getMethod(methodName,value.getClass()); //try getting the value using getter
			if(method!=null)
				method.invoke(obj, value); //set the value using setter
			else {
				Field field=cls.getField(property);
				if(field==null)
						field=cls.getDeclaredField(property);
				field.setAccessible(true);
				field.set(obj, value ); //return the field value directly
			}
				
		} catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	public static <T> T get(Object obj, String property, T defaultValue) {
		
		try {
			
			//covert name property to getName()
			String methodName= String.format("get%s%s",Character.toUpperCase(property.charAt(0)), property.substring(1));
			Class cls=obj.getClass();
			
			Method method=cls.getMethod(methodName); //try getting the value using getter
			if(method!=null)
				return (T)method.invoke(obj);
			else {
				Field field=cls.getField(property);
				if(field==null)
						field=cls.getDeclaredField(property);
				field.setAccessible(true);
				return (T) field.get(obj); //return the field value directly
			}
				
		} catch(Exception ex) {
			ex.printStackTrace();
			return defaultValue;
		}
		
	}

	
	public static Object create(String type, Object ...arguments) {
		AutoObjectCreator<?> creator=new AutoObjectCreator<>();
		
		return  creator.create(type, arguments);
	}
	
	
}
