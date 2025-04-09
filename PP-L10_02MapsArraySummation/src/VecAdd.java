import java.util.concurrent.RecursiveAction;


class VecAdd extends RecursiveAction  {

	public static final int SEQUENTIAL_THRESHOLD = 1;
	private int lo, hi;
	private int[] arr1, arr2, res;

	VecAdd(int[] arr1, int[] arr2, int lo, int hi, int[] res) {
		this.lo = lo;
		this.hi = hi;
		this.arr1 = arr1;
		this.arr2 = arr2;
		this.res = res;
	 }

	 public void compute() {
			if (hi - lo <= SEQUENTIAL_THRESHOLD) {
				for (int i = lo; i < hi; i++) {
					res[i] = arr1[i] + arr2[i];
				}
			} 
			else {
				int mid = (lo + hi) / 2;
				VecAdd left = new VecAdd(arr1, arr2, lo, mid, res);
				VecAdd right = new VecAdd(arr1, arr2, mid, hi, res);
				
				left.fork();
				right.compute();
				left.join();
			}
		}
}
