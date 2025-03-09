public class Main {
  public static void main(String[] args) {
    UnboundedBuffer buffer = new UnboundedBuffer();

    // Start producer first (shouldn't be necessary though)
    Producer producer = new Producer(buffer);
    producer.start();

    Consumer[] consumers = new Consumer[3];

    // Create and start consumer threads
    for (int i = 0; i < consumers.length; ++i) {
      consumers[i] = new Consumer(i, buffer);
      consumers[i].start();
    }
  }
}
