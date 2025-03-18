import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

class ForkJoinRecursiveSum extends RecursiveTask<Integer>  {

	
	private static int idCounter = 0;
	
	public static final int SEQUENTIAL_THRESHOLD = 1;
	private int lo, hi;
	private int[] arr;
	private final int id;

	ForkJoinRecursiveSum(int[] arr, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
		id = getNextId();
	 }

	 public Integer compute() {
			
		 //System.out.println("Computing " + this.toString() + " in Thread " + Thread.currentThread().getName());

			if (hi - lo <= SEQUENTIAL_THRESHOLD) {
				int ans = 0;
				for (int i = lo; i < hi; i++) {
					ans += arr[i];
				}
				return ans;
			} 
			else {
				int mid = (lo + hi) / 2;
				ForkJoinRecursiveSum left = new ForkJoinRecursiveSum(arr, lo, mid);
				ForkJoinRecursiveSum right = new ForkJoinRecursiveSum(arr, mid, hi);
				
				/*
				left.fork();
				right.fork();
				
				int leftAns = left.join();
				int rightAns = right.join();
				*/
				
				
				left.fork();
				int rightAns = right.compute();
				int leftAns = left.join();
				
				
				return leftAns + rightAns;
			}
		}
	 
	 private synchronized static int getNextId() {
			return idCounter++;
		}

	@Override
	public String toString() {
		return "ForkJoinRecursiveSum [lo=" + lo + ", hi=" + (hi-1) + ", id=" + id + "]";
	} 
	 
}
