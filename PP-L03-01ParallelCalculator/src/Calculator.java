
import java.util.Random;

public class Calculator implements Runnable {
  private int number;

  public Calculator(int number) {
    this.number = number;
  }

  @Override
  public void run() {
    // Random random = new Random();

    for (int i = 1; i <= 10; i++) {
      System.out.printf(
          "%s: %d * %d = %d\n",
          Thread.currentThread().getName(),number, i, i * number);
      /*
      try {
        Thread.sleep(random.nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      */
      
    }
  }
}
