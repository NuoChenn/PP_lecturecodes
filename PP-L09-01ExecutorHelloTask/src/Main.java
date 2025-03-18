
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) throws Exception {
   
	  int ntasks = 10;
	  ExecutorService exs = Executors.newFixedThreadPool(4);

	  for (int i=0; i<ntasks; i++) {
	    HelloTask t = new HelloTask("Hello from task " + i); // runnable
	    exs.submit(t);
	  }

	  exs.shutdown(); // initiate shutdown, does not wait, but can’t submit more tasks

  }

  
}
