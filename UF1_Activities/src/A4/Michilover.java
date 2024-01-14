package A4;

import java.util.concurrent.Callable;

public class Michilover implements Callable<Integer> {
	private GameController gc;

	public Michilover(GameController gc) {
		this.gc = gc;
	}

	@Override
	public Integer call() throws Exception {
		//esperar a ser 5
		gc.Michilover();
		gc.incrementarMichiTokens(50);
		return 0;
	}

}
