package A4;

import java.util.concurrent.Callable;

public class Michibi implements Callable<Integer>{
	GameController gc;
	public Michibi(GameController gc) {
		this.gc=gc;
	}
	@Override
	public Integer call() {
		try {
			while (true) {
				Thread.sleep(1000);
				gc.incrementarMichiTokens(1);
				
			}
		}catch(Exception e) {
			System.err.println(Thread.currentThread()+" [Michibi: He acabat.]");
		}
		return 1;
	}

}
