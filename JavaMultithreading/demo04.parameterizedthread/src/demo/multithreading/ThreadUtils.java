package demo.multithreading;

public class ThreadUtils {

	public static void print(Object obj, Object...args) {
		String output="";
		
		if(args.length==0)
			output=obj.toString();
		else
			output=String.format(obj.toString(), args);
		
		System.out.printf("[%d] %s", Thread.currentThread().getId(), output);
	}
	
	
	public static void println(Object obj, Object ...args) {
		// TODO Auto-generated method stub
		
		print(obj+"\n",args);
		
	}

}
