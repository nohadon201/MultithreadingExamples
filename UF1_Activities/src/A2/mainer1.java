package A2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mainer1 {
	public static void main(String[] args) {
		ArrayList<Long> arr = new ArrayList<Long>();
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			arr.add(r.nextLong());
		}
		long tiempoInicio, tiempoFin;
		
		tiempoInicio = System.nanoTime();
		
		ExecutorService ex = Executors.newCachedThreadPool();
		Future<Long[]> fut = ex.submit(new MyThreat(arr));
		ex.shutdown();
		try {
			System.out.println(Arrays.toString(fut.get()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tiempoFin = System.nanoTime();
		System.out.println("Temps que ha trigat: "+((tiempoFin-tiempoInicio)/1000000d));
		
	}
}
