package A2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mainer2 {
	public static void main(String[] args) {
		ArrayList<Long> arr = new ArrayList<Long>();
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			arr.add(r.nextLong());
		}
		long tiempoInicio, tiempoFin;
		
		tiempoInicio = System.nanoTime();
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		Future<Long[]> fut1 = ex.submit(new MyThreat2(arr,true));
		Future<Long[]> fut2 = ex.submit(new MyThreat2(arr,false));
		ex.shutdown();
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
	}
}
