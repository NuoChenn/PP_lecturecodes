
public class MaxFinder extends Thread {
  public Integer max;
  private Integer[] source;
  private int start;
  private int end;

  public MaxFinder(Integer[] source, int start, int end) {
    this.source = source;
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {
    int max = Integer.MIN_VALUE;

    for (int i = start; i < end; ++i)
      if (max < source[i])
        max = source[i];

    this.max = max;
  }
}
