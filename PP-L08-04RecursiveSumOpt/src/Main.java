
public class Main {
  public static void main(String[] args) throws Exception {
   
	  int arrSize = 8;
	  int[] myIntArray = new int[arrSize];
	  for(int i=0; i<arrSize; i++)
		  myIntArray[i] = 1;
	  
	  SumThread t = new SumThread(myIntArray, 0, arrSize);
	  t.start();
	  t.join();
	  
	  System.out.print("result: " + t.result);
  }

  
}
