import java.util.concurrent.ForkJoinPool;

public class Main {

	private static final ForkJoinPool fjPool = new ForkJoinPool();
	
	public static void main(String[] args) throws Exception {
	  	  
	  int[] myIntArray1 = new int[8];
	  int[] myIntArray2 = new int[8];
	  
	  assert (myIntArray1.length == myIntArray2.length);
	  
	  int[] ans = new int[myIntArray1.length];
	    
	  for(int i=0; i<myIntArray1.length; i++)
		  myIntArray1[i] = myIntArray2[i] = 1;
	  
	  fjPool.invoke(new VecAdd(myIntArray1, myIntArray2, 0, ans.length, ans));
	  
	  System.out.print("answer array: ");
	  for(int i=0; i<ans.length; i++)
		  System.out.print(ans[i] + " ");
	}
	
}
