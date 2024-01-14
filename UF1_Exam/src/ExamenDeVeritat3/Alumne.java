package ExamenDeVeritat3;

import java.util.Random;
import java.util.concurrent.Callable;

public class Alumne implements Callable<Integer> {

	private Botiga b;

	private Empleats e;

	private Random r = new Random();
	
	private String cosad;
	
	public Alumne(Botiga b, Empleats emp, String cosa_a_demanar) {
		this.b = b;
		this.e = emp;
		this.cosad=cosa_a_demanar;
		
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
			
			if(b.existeixCosa(cosad)) {
				b.comprar(cosad);
			}else {
				System.err.println("NOOOOOOOOOO YO QUERÍA MI "+cosad.toUpperCase()+" >:'((((((((((( MALDITO HECTOR");
			}
			
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
