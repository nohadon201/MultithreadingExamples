import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainer3 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			executor.execute(new Temporitzador(r.nextInt(10)+1));
		}
		System.out.println("Apagant threads...");
		executor.shutdown();
		for (int i = 5; i >= 1; i--) {
			try {
				Thread.sleep(1000);
				System.out.println("EXECUTOR: "+i);
			}catch(Exception e) {
				
			}
		}
		executor.shutdownNow();
		
	}
}
