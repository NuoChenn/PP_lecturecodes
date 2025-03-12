
public class Main {
  public static void main(String[] args) {
   
	  int arrSize = 100000;
	  int[] myIntArray = new int[arrSize];
	  for(int i=0; i<arrSize; i++)
		  myIntArray[i] = 1;
	  
	  SumThread t = new SumThread(myIntArray, 0, arrSize);
	  t.start();
	  try {
		t.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  System.out.print("result: " + t.result);
  }
  
}
