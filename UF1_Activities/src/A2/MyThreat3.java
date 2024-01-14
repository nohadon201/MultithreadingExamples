package A2;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class MyThreat3 implements Callable<Long[]> {
	private ArrayList<Long> arr;
	private long min;
	private long max;
	private int init, end;

	public MyThreat3(ArrayList<Long> arr, int init, int end) {
		this.arr = arr;
		min = 0;
		max = 0;
		this.init = init;
		this.end = end;
	}

	@Override
	public Long[] call() throws Exception {
		for (int i = this.init; i < this.end; i++) {
			if (arr.get(i) > max) {
				this.max = arr.get(i);
			}
			if (arr.get(i) < min) {
				this.min = arr.get(i);
			}
		}
		Long[] arr2 = new Long[2];
		arr2[0] = min;
		arr2[1] = max;
		return arr2;
	}

}
