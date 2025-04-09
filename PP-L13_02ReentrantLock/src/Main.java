
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
 
	
public static void main(String[] args) {
	
	System.out.println("== Explicit Lock ==");
	
	String[] myThreads = {"Thread 1","Thread 2","Thread 3","Thread 4"};
	
	Lock lock = new ReentrantLock(true);
	
	for(String threadName:myThreads) {
		new Thread(new MyThread(lock),threadName).start();
	}

}
 
}
