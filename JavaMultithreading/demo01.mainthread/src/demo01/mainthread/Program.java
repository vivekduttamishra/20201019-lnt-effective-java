package demo01.mainthread;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//every application has at least one thread
		Thread currentThread=Thread.currentThread();
		
		System.out.println(currentThread);
		
		currentThread.setName("My Only Thread");
		
		currentThread.setPriority(Thread.NORM_PRIORITY+2);
		
		System.out.println(currentThread);
	}

}
