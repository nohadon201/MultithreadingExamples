
public class Temporitzador implements Runnable{
	private int segons;
	public Temporitzador(int a) {
		this.segons=a;
		System.out.println("Nombre random: "+a);
	}
	@Override
	public void run() {
		for (int i = this.segons; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("aaaaaaaaaaaaaaaaaaa me caguié, me quedaban "+i+" segundos");
				return;
			}
			System.out.println(Thread.currentThread().getName()+"  | seconds: "+i);
		}
	}
	
}
