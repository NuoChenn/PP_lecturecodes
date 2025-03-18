
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		  int arrSize = 8;
		  int[] myIntArray = new int[arrSize];
		  for(int i=0; i<arrSize; i++)
			  myIntArray[i] = 1;
		  
		  ExecutorService exs = Executors.newFixedThreadPool(4);
		  
		  sumRecCall t = new sumRecCall(exs, myIntArray, 0, arrSize); // callable
		  Future<Integer> res = exs.submit(t);
		  
		  System.out.print("result: " + res.get());
	}
}
