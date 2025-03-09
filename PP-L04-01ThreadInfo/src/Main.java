
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
  static final int N = 5;
  static final String SEPARATOR = "\n" + "=".repeat(80);

  public static void main(String[] args) {
    // This try-with-resource block ensures that file and writer are closed after the block,
    // even if an exception is thrown.
    try (FileWriter file = new FileWriter("log.txt");
         PrintWriter writer = new PrintWriter(file)) {

      runAndMonitorCalculators(writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Runs N calculators in parallel and regularly logs various information to the given writer.
   * @param writer The PrintWriter information is written to.
   */
  private static void runAndMonitorCalculators(PrintWriter writer) {
    Calculator[] calculators = new Calculator[N];
    Thread[] threads = new Thread[N];

    //
    // Step 1: Instantiate N calculators and corresponding threads
    //

    for (int i = 0; i < N; ++i) {
      calculators[i] = new Calculator(i); // Create calculator object
      threads[i] = new Thread(calculators[i]); // Create calculator thread

      // Alternate between max and min thread priority
      threads[i].setPriority(i % 2 == 0 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY);

      logInfo(writer, calculators[i], threads[i]);

      threads[i].start(); // Start thread
    }

    //
    // Step 2: Run all threads until completion
    //

    boolean finished;

    do {
      writer.println(SEPARATOR);
      finished = true;

      // busy waiting
      for (int i = 0; i < N; ++i) { // Iterate over all threads
        if (threads[i].getState() != Thread.State.TERMINATED) {
          logInfo(writer, calculators[i], threads[i]);

          finished = false;
        }
      }
    } while (!finished); // Loop until all threads finished

    //
    // Step 3: Log final information
    //

    writer.println(SEPARATOR);

    for (int i = 0; i < N; ++i) {
      logInfo(writer, calculators[i], threads[i]);
    }
  }

  /**
   * Logs information about calculator and thread to writer.
   * @param writer The PrintWriter information is written to.
   * @param calculator Calculator whose information is logged.
   * @param thread Thread whose information is logged.
   */
  private static void logInfo(PrintWriter writer, Calculator calculator, Thread thread) {
    writer.printf("\nID: %d\n", calculator.number);
    writer.printf("State: %s\n", thread.getState().toString());
    writer.printf("Priority: %d\n", thread.getPriority());
  }
}
