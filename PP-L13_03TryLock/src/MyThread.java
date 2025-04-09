import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {

	private Lock lock;

	public MyThread(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		printMessage("Entered run method...trying to lock");
	
		try {
			if(lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				try {
					printMessage("Lock acquired");
					try{
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} finally {
					printMessage("Lock released");
					lock.unlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		printMessage("End of run method");
	}

	private void printMessage(String msg){
		System.out.println(Thread.currentThread().getName()+" : "+msg);
	}


}