
public class Main {
  public static void main(String[] args) {
   	  
	  int size = 100;
	  int[] myIntArray = new int[size];
	  for(int i=0; i<size; i++)
		  myIntArray[i] = 1;
	  
	  int result = sum(myIntArray, 10); // array reference and number of threads
	  
	  System.out.println("result: " + result);
	  
  }
  
  static int sum(int[] arr, int numTs){
	  int ans = 0;
	  SumThread[] ts = new SumThread[numTs];
	  
	  for(int i=0; i < numTs; i++){
	   ts[i] = new SumThread(arr,(i*arr.length)/numTs,
	                             ((i+1)*arr.length)/numTs);
	   System.out.println("start thread " + i + " [" + (i*arr.length)/numTs + " " + ((i+1)*arr.length)/numTs + "]");
	   ts[i].start();
	  }
	  
	  for(int i=0; i < numTs; i++) { 
	    try {
			ts[i].join();
			//System.out.println("joined thread " + i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    ans += ts[i].ans;
	  }
	  
	  return ans;
	}


  
}
