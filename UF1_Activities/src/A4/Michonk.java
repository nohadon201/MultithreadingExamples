package A4;

import java.util.concurrent.Callable;

public class Michonk implements Callable<Integer> {
	GameController gc;

	public Michonk(GameController gc) {
		this.gc = gc;
	}

	@Override
	public Integer call() {
		try {
			while (true) {
				Thread.sleep(1000);
				gc.incrementarMichiTokens(5);

			}
		} catch (Exception e) {
			System.err.println(Thread.currentThread() + " [Michonk: He acabat.]");
		}
		return 1;
	}

}
