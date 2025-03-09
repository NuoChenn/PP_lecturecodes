
public class Main {
  // UNCHANGED *** Same Main.java as before *** UNCHANGED

  public static void main(String[] args) {

    final int MAX_TICKS = Integer.MAX_VALUE / 100;

    // Shared counter value initially 0
    LongCell sharedValue = new LongCell(0);

    // Create two counters, incrementing by +1/-1
    Counter up   = new Counter(sharedValue,  1, MAX_TICKS);
    Counter down = new Counter(sharedValue, -1, MAX_TICKS);

    // Create two threads, executing the counters
    Thread upWorker = new Thread(up);
    Thread downWorker = new Thread(down);

    // Start the threads
    upWorker.start();
    downWorker.start();

    // Join threads, i.e. wait until both terminated
    try {
      upWorker.join();
      downWorker.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
      return;
    }

    // Show results
    System.out.printf("\nUp's ticks:   %d\n", up.ticks);
    System.out.printf("Down's ticks: %d\n", down.ticks);
    System.out.printf("Shared value: %d\n", sharedValue.get());
  }
}
