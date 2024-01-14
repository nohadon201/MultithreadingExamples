package A2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mainer {
	public static void main(String[] args) {
		ArrayList<Long> arr = new ArrayList<Long>();
		Random r = new Random();
		for (int i = 0; i < 10000000; i++) {
			arr.add(r.nextLong());
		}
		long tiempoInicio, tiempoFin;
		
		/**
		 * ######################## EXERCICI 1 ############################
		 */
		
		
		ExecutorService ex = Executors.newCachedThreadPool();
		tiempoInicio = System.nanoTime();
		Future<Long[]> fut = ex.submit(new MyThreat3(arr,0,arr.size()));
		ex.shutdown();
		try {
			Long[] arraylong = fut.get();
			System.out.print("Mínim: "+arraylong[0]+" ");
			System.out.println("Màxim: "+arraylong[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tiempoFin = System.nanoTime();
		System.out.println("Temps que ha trigat: "+((tiempoFin-tiempoInicio)/1000000d));
		
		/**
		 * ######################## EXERCICI 2 ############################
		 */
		
		ExecutorService ex2 = Executors.newCachedThreadPool();
		tiempoInicio = System.nanoTime();
		
		Future<Long[]> fut1 = ex2.submit(new MyThreat3(arr,0, (int)(arr.size()/2)));
		Future<Long[]> fut2 = ex2.submit(new MyThreat3(arr,(int)(arr.size()/2), arr.size()));
		ex2.shutdown();
		try {
			Long[] prim = fut1.get();
			Long[] sec = fut2.get();
			if(prim[0]<sec[0]) {
				System.out.print("Mínim: "+prim[0]+" ");
			}else{
				System.out.print("Mínim: "+sec[0]+" ");
			}
			if(prim[1]<sec[1]) {
				System.out.println("Màxim: "+sec[1]);
			}else {
				System.out.println("Màxim: "+prim[1]);
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tiempoFin = System.nanoTime();
		System.out.println("Temps que ha trigat: "+((tiempoFin-tiempoInicio)/1000000d));
		
		/**
		 * ######################## EXERCICI 3 ############################
		 */
		
		ExecutorService ex3 = Executors.newCachedThreadPool();
		tiempoInicio = System.nanoTime();

		int current_number_Threat = Runtime.getRuntime().availableProcessors();

		ArrayList<Future<Long[]>> arr2 = new ArrayList<Future<Long[]>>();

		for (int i = 0; i < current_number_Threat; i++)
			arr2.add(ex3.submit(new MyThreat3(arr, i * ((arr.size() / current_number_Threat) - 1),
					(i * ((arr.size() / current_number_Threat)-1)  + (arr.size() / current_number_Threat)))));

		ex3.shutdown();

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
