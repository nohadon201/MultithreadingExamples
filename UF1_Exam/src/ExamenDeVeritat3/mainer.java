package ExamenDeVeritat3;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mainer {
	public static void main(String[] args) {
		Botiga b = new Botiga();
		Empleats e = new Empleats();
		ArrayList<Alumne> arr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arr.add(new Alumne(b, e,"Cafè"));
		}
		for (int i = 0; i < 4; i++) {
			arr.add(new Alumne(b, e,"Croissant Nocilla"));
		}
		for (int i = 0; i < 4; i++) {
			arr.add(new Alumne(b, e,"Entrepà vegetal"));
		}
		for (int i = 0; i < 2; i++) {
			arr.add(new Alumne(b, e,"Perrillas"));
		}
		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> arr2 = new ArrayList<>();
		for (Alumne al : arr) {
			arr2.add(executor.submit(al));
		}
		executor.shutdown();
		for (Future<Integer> future : arr2) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		b.print();
	}
}
