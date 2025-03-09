
import java.util.Random;

public abstract class Duellist extends Thread {
  protected int repetitions;

  public Duellist(int repetitions) {
    this.repetitions = repetitions;
  }

  abstract void fight();

  @Override
  public void run() {
    Random random = new Random();

    while(true) {
      try {
        fight();
        System.out.flush();

        sleep(random.nextInt(500));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
