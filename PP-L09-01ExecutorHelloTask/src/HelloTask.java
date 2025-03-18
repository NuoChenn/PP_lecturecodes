class HelloTask implements Runnable {

	String msg;

	public HelloTask(String msg) {
		this.msg = msg;
	}

	public void run() {
		long id = Thread.currentThread().getId();
		System.out.println(msg + " from thread:" + id);
	}
}
