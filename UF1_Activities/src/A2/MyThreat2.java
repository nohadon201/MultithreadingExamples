package A2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class MyThreat2 implements Callable<Long[]> {
	private ArrayList<Long> arr;
	private long min;
	private long max;
	private boolean primer;
	public MyThreat2(ArrayList<Long> arr,boolean primer) {
		this.arr=arr;
		min=0;
		max = 0;
		this.primer=primer;
	}
	@Override
	public Long[] call() throws Exception {
		if(primer) {
			min=arr.get(0);
			max=arr.get(0);
			for (int i = 0; i < (int)arr.size()/2; i++) {
				if(arr.get(i)>max) {
					this.max=arr.get(i);
				}else if(arr.get(i)<min) {
					this.min=arr.get(i);
				}
			}
		}else {
			min=arr.get((int)arr.size()/2);
			max=arr.get((int)arr.size()/2);
			for (int i = (int)arr.size()/2; i < arr.size(); i++) {
				if(arr.get(i)>max) {
					this.max=arr.get(i);
				}else if(arr.get(i)<min) {
					this.min=arr.get(i);
				}
			}
		}
		Long[] arr2 = new Long[2];
		arr2[0]=min;
		arr2[1]=max;
		return arr2;
	}

}
