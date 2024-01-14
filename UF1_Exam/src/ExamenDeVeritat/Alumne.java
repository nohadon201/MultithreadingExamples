package ExamenDeVeritat;

import java.util.Random;
import java.util.concurrent.Callable;

public class Alumne implements Callable<Integer> {

	private Botiga b;

	private Empleats e;

	private Random r = new Random();
	public Alumne(Botiga b, Empleats emp) {
		this.b = b;
		this.e = emp;
		
	}

	@Override
	public Integer call() {
		try {
			while (b.esperarFora()) {
				synchronized (b) {
					b.wait();	
				}
			}
			b.sumarClient(1);

			while (e.Ocupats()) {
				synchronized (e) {
					e.wait();
				}
			}
			
			e.sumarAlumneAtes(1);
			
			Thread.sleep(r.nextInt(5)+5);
			
			e.sumarAlumneAtes(-1);
			b.sumarClient(-1);
			
			synchronized (e) {
				e.notifyAll();
			}
			
			synchronized (b) {
				b.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
