
public class LongCell {
  private long value;

  public LongCell(long value) {
    this.value = value;
  }

  public long get() {
    return value;
  }

  public void inc(long delta) {
    this.value += delta;
  }
}
