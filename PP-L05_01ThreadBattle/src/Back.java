
public class Back extends Duellist {
  public Back(int repetitions) {
    super(repetitions);
  }

  @Override
  public void fight() {
    System.out.print("\b".repeat(repetitions));
  }
}
