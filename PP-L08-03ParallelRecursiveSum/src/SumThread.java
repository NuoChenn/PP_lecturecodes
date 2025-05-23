
class SumThread extends java.lang.Thread {

	int[] xs;
	int h, l;
	int result;
	int id;
	private static int idCounter = 0;
	static int SEQ_CUTOFF = 1;

	
	public SumThread(int[] xs, int l, int h){
		this.xs = xs;
		this.h = h;
		this.l =l;
		this.id = getNextId();
		setName(id + "");
	}

	private synchronized static int getNextId() {
		return idCounter++;
	}

  public void run() { //override must have this type
	  System.out.println("Running id " + id + " in thread " + Thread.currentThread().getName() 
			  				+ " [" + l + ".." + (h-1) + "]");
	  int size = h-l;
	  
	  if (size <= SEQ_CUTOFF){
	      for(int i=l; i<h; i++)
	      {
	    	  result += xs[l];
	      }
	      return;
	  }


	  int mid = size / 2;
	  SumThread t1 = new SumThread(xs, l, l + mid);
	  SumThread t2 = new SumThread(xs, l + mid, h);

	  
	  t1.start();
	  t2.start();
	  try {
		  	t1.join();
			t2.join();
		  } catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		  }
	  
	 
	  result = t1.result + t2.result;
  }
}

