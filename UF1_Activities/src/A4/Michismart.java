package A4;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Michismart implements Callable<Integer> {
	private GameController gc;

	public Michismart(GameController gc) {
		this.gc = gc;
	}
	@Override
	public Integer call() throws Exception {
		
		Thread.sleep(10000);
		gc.incrementarMichiTokens(1000);
		
		return 0;
	}

}
