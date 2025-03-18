

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class sumRecCall implements Callable<Integer> {

	int[] xs;
	int h;
	int l;
	int result;
	ExecutorService ex;

	public sumRecCall(ExecutorService ex, int[] xs, int l, int h) {
		this.xs = xs;
		this.h = h;
		this.l = l;
		this.ex = ex;
	}

	public Integer call() throws Exception {
		  int size = h-l;
		  if (size == 1)
		    return xs[l];

		  int mid = size / 2;
		  sumRecCall c1 = new sumRecCall(ex, xs, l, l + mid);
		  sumRecCall c2 = new sumRecCall(ex, xs, l + mid, h);

		  Future<Integer> f1 = ex.submit(c1);
		  Future<Integer> f2 = ex.submit(c2);

		  return f1.get() + f2.get();
		}

}