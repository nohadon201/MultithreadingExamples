import java.util.Random;

public class mainer {
	public static void main(String[] args) {
		Random r = new Random();
		Thread miTimer = new Thread(new Temporitzador(r.nextInt(10)+1));
		System.out.println("Comença el Thread: ");
		miTimer.start();
		
	}
}
