import java.util.concurrent.ForkJoinPool;
import java.lang.System;

public class Main {

	
	private static final ForkJoinPool fjPool = new ForkJoinPool(4);
	
	public static void main(String[] args) throws Exception {
	  long start = System.nanoTime();
	  
	  //System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
	  	  
	  int[] myIntArray = new int[1000000];
	  for(int i=0; i<myIntArray.length; i++)
		  myIntArray[i] = 1;
	  
	  int sum = sum(myIntArray);	  
	  System.out.println("sum: " + sum);
	  
	  long finish = System.nanoTime();
	  long timeElapsed = finish - start;
	  System.out.println("timeElapsed in ms: " + timeElapsed/1000000.0);
	  
	}

	public static int sum(int[] arr) throws InterruptedException {
		return fjPool.invoke(new ForkJoinRecursiveSum(arr, 0, arr.length));
	}
	
}
