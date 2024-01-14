package A2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mainer3 {
	public static void main(String[] args) {
		ArrayList<Long> arr = new ArrayList<Long>();
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			arr.add(r.nextLong());
		}
		long tiempoInicio, tiempoFin;

		tiempoInicio = System.nanoTime();

		ExecutorService ex = Executors.newCachedThreadPool();

		int current_number_Threat = Runtime.getRuntime().availableProcessors();

		ArrayList<Future<Long[]>> arr2 = new ArrayList<Future<Long[]>>();

		for (int i = 0; i < current_number_Threat; i++)
			arr2.add(ex.submit(new MyThreat3(arr, i * ((arr.size() / current_number_Threat) - 1),
					(i * ((arr.size() / current_number_Threat) - 1) + (arr.size() / current_number_Threat)))));

		ex.shutdown();

		Long[] max = new Long[arr2.size()];
		Long[] min = new Long[arr2.size()];

		try {
			for (int i = 0; i < arr2.size(); i++) {
				Long[] array;
				array = arr2.get(i).get();
				max[i] = array[1];
				min[i] = array[0];
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long maxv = max[0];
		long minv = min[0];
		for (int i = 0; i < arr2.size(); i++) {
			if (maxv < max[i]) {
				maxv = max[i];
			}else if (minv > min[i]) {
				minv = min[i];
			}
		}
		System.out.println("Mínim: " + minv + " Máxim: " + maxv);
		tiempoFin = System.nanoTime();
		System.out.println("Temps que ha trigat: " + ((tiempoFin - tiempoInicio) / 1000000d));
	}
}
