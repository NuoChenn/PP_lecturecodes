

import java.util.HashSet;
import java.util.Set;

public class LoggingExceptionHandler implements Thread.UncaughtExceptionHandler {
  public Set<Thread> abortedThreads = new HashSet<>();

  @Override
  public void uncaughtException(Thread thread, Throwable throwable) {
    System.out.println("│An exception has been captured");
    System.out.printf("│  Thread: %s (id %d)\n", thread.getName(), thread.getId());
    System.out.printf("│  Status: %s\n", thread.getState());

    System.out.printf(
        "│  Exception: %s: %s\n",
        throwable.getClass().getName(),
        throwable.getMessage());

    System.out.println("│  Stack Trace:");
    for (StackTraceElement elem : throwable.getStackTrace())
      System.out.printf("│    %s\n", elem);

    abortedThreads.add(thread);
  }
}
