
public class Main {
	
  public static void main(String[] args) {
   
	  int[] myIntArray = new int[100];
	  for(int i=0; i<100; i++)
		  myIntArray[i] = 1;
	  
	  int result = sum(myIntArray);
	  
	  System.out.print("result: " + result);
  }
  
  
  static int sum(int[] arr) {
	  int len = arr.length;
	  int ans = 0;
	  SumThread[] ts = new SumThread[4];
	  
	  for(int i=0; i < 4; i++){ // do parallel computations
	    ts[i] = new SumThread(arr, i*len/4, (i+1)*len/4);
	    System.out.println("start thread " + i + " [" + i*len/4 + ".." + (i+1)*len/4 + "]");
	    ts[i].start();
	  }
	  
	  for(int i=0; i < 4; i++) { // combine results
		  try {
			ts[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  ans += ts[i].ans;
	  }	
	  
	
	  
	  return ans;
	}
  
}
