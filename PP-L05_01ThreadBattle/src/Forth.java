
public class Forth extends Duellist {
  public Forth(int repetitions) {
    super(repetitions);
  }

  @Override
  public void fight() {
    System.out.print("*".repeat(repetitions));
  }
}
