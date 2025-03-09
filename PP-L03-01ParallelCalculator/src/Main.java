public class Main {
  public static void main(String[] args) {
    // Create 10 threads, each for an n in [1, 10],
    // calculating and printing multiplication tables from 1n to 10n
    for (int i = 1; i <= 10; ++i){
      Calculator calculator = new Calculator(i);

      Thread thread = new Thread(calculator);
      thread.start();
    }
  }
}
