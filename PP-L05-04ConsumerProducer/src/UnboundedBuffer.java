
import java.util.ArrayDeque;
import java.util.Deque;

// A simple, unbounded buffer that is not thread-safe
// (i.e. does not perform its own synchronisation)
public class UnboundedBuffer {
  // The buffer internally maintains a deque of longs
  private final Deque<Long> elements;

  public UnboundedBuffer() {
    this.elements = new ArrayDeque<>();
  }

  public boolean isEmpty() {
    return elements.isEmpty();
  }

  public void add(long value) {
    elements.addLast(value);
  }

  public long remove() {
    return elements.removeFirst();
  }
}
