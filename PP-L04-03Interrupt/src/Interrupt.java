import java.util.Timer;
import java.util.TimerTask;

public class Interrupt {

    public static void main(String[] args) {
        Timer timer = new Timer(); // constructor of timer starts a thread
        Thread buggyThread = new Thread(new RunnableThatTakesForever());
        buggyThread.start();
 
        // calls interrupt on buggyThread
        timer.schedule(new MyTimerTask(buggyThread), 8000);
        
        // Main thread would be blocked forever by buggy thread
        try {
            System.out.println("Waiting for other thread");
            buggyThread.join();
        } catch (InterruptedException e) {
        	// interrupt exception in main
        	System.out.println("Interrupted exception main"); // if waiting thread gets interrupted (timeout, another thread invoking interrupt() on the main thread)
        }
        
        System.out.println("Resume working");

        System.exit(0); // Also force stop buggy thread
    }

    
    private static class RunnableThatTakesForever implements Runnable {
        @Override
        public void run() {
        	try {
                // This is a bug: Threads takes forever to finish
                Thread.sleep(10000000000L);
            } catch (InterruptedException e) {
            	// interrupt exception in buggyThread
            	System.out.println("Interrupted exception RunnableThatTakesForever");
            }
        }
    }

    
    private static class MyTimerTask extends TimerTask {

        private final Thread thread;

        private MyTimerTask(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("Now interrupting the other thread");
            // Invoking interrupt on the thread object
            // For the interrupt mechanism to work correctly, 
            // the interrupted thread must support its own interruption
            thread.interrupt(); 
        }
    }


 
}
