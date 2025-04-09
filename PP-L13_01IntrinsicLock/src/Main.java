
public class Main {
 
	
public static void main(String[] args) {
	
	System.out.println("== Intrinsic Lock ==");
	
	String[] myThreads = {"Thread 1","Thread 2","Thread 3","Thread 4"};
	
	Object monitor = new Object();
	
	for(String threadName:myThreads) {
		new Thread(new MyThread(monitor),threadName).start(); // myThread is a runnable
	}

}
 
}
