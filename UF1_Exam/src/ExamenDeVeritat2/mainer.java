package ExamenDeVeritat2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mainer {
	public static void main(String[] args) {

		Botiga b = new Botiga();
		Empleats e = new Empleats();
		ArrayList<Alumne> arr = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			switch (r.nextInt(3) + 1) {
				case 1:
					arr.add(new Alumne(b, e, "Cafè"));
					break;
				case 2:
					arr.add(new Alumne(b, e, "Croissant Nocilla"));
					break;
				case 3:
					arr.add(new Alumne(b, e, "Entrepà vegetal"));
					break;
				case 4:
					arr.add(new Alumne(b, e, "Perrillas"));
					break;
			}
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
