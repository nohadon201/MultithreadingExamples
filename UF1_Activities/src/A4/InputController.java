package A4;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class InputController implements Callable<Integer> {
	private GameController gc;
	public InputController(GameController gc) {
		this.gc = gc;
	}
	@Override
	public Integer call() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			switch(sc.nextInt()) {
				case 0:
					this.gc.quitGame();
					return 0;
				case 1: 
					this.gc.action1();
					break;
				case 2:
					this.gc.action2();
					break;
				case 3:
					this.gc.action3();
					break;
				case 4:
					this.gc.action4();
					break;
				default:
					System.out.println("");
					System.out.println("+1 Michitoken");
					System.out.println("");
					gc.incrementarMichiTokens(1);
					break;
			}
		}
		
	}

}
