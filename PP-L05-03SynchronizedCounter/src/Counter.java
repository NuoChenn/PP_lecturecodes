
public class Counter implements Runnable {
  // UNCHANGED *** Same Main.java as before *** UNCHANGED

  public int ticks = -1;

  private LongCell sharedValue;
  private int delta;
  private int maxTicks;

  /**
   * Creates a new counter.
   * @param sharedValue LongCell to inc-/decrement.
   * @param delta       Delta by which to inc-/decrement.
   * @param maxTicks    Number of inc-/decrements to perform.
   */
  public Counter(LongCell sharedValue, int delta, int maxTicks) {
    this.sharedValue = sharedValue;
    this.delta = delta;
    this.maxTicks = maxTicks;
  }

  @Override
  public void run() {
    ticks = 0;

    // Perform maxTicks inc-/decrements
    while (ticks < maxTicks) {
      sharedValue.inc(delta); // A single inc-/decrement

      // Output some information in certain intervals
      if (ticks % 1_000_000 == 0) {
        System.out.printf("delta = %2d, ticks = %d\n", delta, ticks);
      }

      ++ticks;
    }
  }
}
