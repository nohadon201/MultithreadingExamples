package A2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class MyThreat implements Callable<Long[]> {
	private ArrayList<Long> arr;
	private long min;
	private long max;

	public MyThreat(ArrayList<Long> arr) {
		this.arr = arr;
		min = 0;
		max = 0;
	}

	@Override
	public Long[] call() throws Exception {
		int ind = 0;
		min = arr.get(0);
		max = arr.get(0);
		for (Long lo : arr) {
			if (lo < min) {
				min = lo;
			} else if (lo > max) {
				max = lo;
			}
			ind++;
		}
		Long[] arr2 = new Long[2];
		arr2[0] = min;
		arr2[1] = max;
		return arr2;
	}

}
