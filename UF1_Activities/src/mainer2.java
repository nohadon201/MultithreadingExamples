import java.util.ArrayList;
import java.util.Random;

public class mainer2 {
	public static void main(String[] args) {
		try {
			Random r = new Random();
			ArrayList<Thread> arr = new ArrayList<Thread>();
			for (int i = 0; i < 10; i++) {
				Thread.sleep(500);
				Thread t = new Thread(new Temporitzador(r.nextInt(10) + 1));
				t.start();
				arr.add(t);
			}
			for (int i = 0; i < arr.size(); i++) {
				arr.get(i).join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
