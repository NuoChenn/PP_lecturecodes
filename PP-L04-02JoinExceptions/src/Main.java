

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    final int N = 100_000;

    Integer[] source = getData(N);

    // Create two maximum finders (which extend Thread),
    // one per array half
    MaxFinder firstHalf = new MaxFinder(source, 0, N/2);
    MaxFinder secondHalf = new MaxFinder(source, N/2, N);

    // Set meaningful thread names (not necessary)
    firstHalf.setName("firstHalf");
    secondHalf.setName("secondHalf");
    
    /*
    // Create an exception handler and register it with the two threads
    LoggingExceptionHandler exceptionHandler = new LoggingExceptionHandler();
    firstHalf.setUncaughtExceptionHandler(exceptionHandler);
    secondHalf.setUncaughtExceptionHandler(exceptionHandler);
    */

    firstHalf.start();
    secondHalf.start();

    try {
      firstHalf.join();
      secondHalf.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    /*
    if (exceptionHandler.abortedThreads.contains(firstHalf) ||
    	exceptionHandler.abortedThreads.contains(secondHalf)) {
      System.out.println("**** Ups, something went wrong ****");
    } else
    */
    {
      System.out.printf("1st half's max: %d\n", firstHalf.max);
      System.out.printf("2nd half's max: %d\n", secondHalf.max);
      System.out.printf("Parallel max:   %d\n", Math.max(firstHalf.max, secondHalf.max));
      System.out.printf("Sequential max: %d\n", Collections.max(Arrays.asList(source))); // Potentially inefficient
    }
  }

  private static Integer[] getData(int size) {
    Random random = new Random();
    Integer[] source = new Integer[size];

    for (int i = 0; i < size; ++i) // Start with i = 1 to stir up trouble
      source[i] = random.nextInt();

    return source;
  }
}
