import java.util.concurrent.locks.Lock;

public class MyThread implements Runnable {

	private Lock lock;

	public MyThread(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		printMessage("Entered run method...trying to lock");
	
		lock.lock();
		try{
			printMessage("Lock acquired");
			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		finally{
			printMessage("Lock released");
			lock.unlock();
		}
	
		printMessage("End of run method");
	}

	private void printMessage(String msg){
		System.out.println(Thread.currentThread().getName()+" : "+msg);
	}


}