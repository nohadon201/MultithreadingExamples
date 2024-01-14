package A4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GameController {
	private Queue<Michismart> notificar_smarts = new ConcurrentLinkedQueue<>();
	
	private Object semafor_main = new Object();
	
	private HashMap<String, Integer> michi_count = new HashMap<String, Integer>();

	private Object michiSemaforo = new Object();

	private int michiTokens = 0;

	private ExecutorService executor = Executors.newCachedThreadPool();

	private ArrayList<Future<Integer>> comprovator = new ArrayList<Future<Integer>>();

	ArrayList<Future<Integer>> arr = new ArrayList<>();

	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.michi_count.put("michibi", 0);
		gc.michi_count.put("michonk", 0);
		gc.michi_count.put("michilover", 0);
		gc.michi_count.put("michismart", 0);
		gc.printGUI();
		Future<Integer> f = gc.executor.submit(new InputController(gc));
		synchronized (gc.semafor_main) {
			try {
				gc.semafor_main.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			int a = f.get();
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Iterator<Future<Integer>> i = gc.comprovator.iterator();
		while (i.hasNext()) {
			try {
				System.out.println(i.next().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	public void printGUI() {
		synchronized (this.michi_count) {
			System.out.println("");
			System.out.println("----------------------------------");
			System.out.println("MichiTokens: " + michiTokens);
			System.out.println("Michis actuals: ");
			System.out.println("Michibis: " + this.michi_count.get("michibi"));
			System.out.println("Michonks: " + this.michi_count.get("michonk"));
			System.out.println("MIchilovers: " + this.michi_count.get("michilover"));
			System.out.println("Michismarts: " + this.michi_count.get("michismart"));
			System.out.println("");
			System.out.println("0 - Exit Game");
			System.out.println("1 - Action 1");
			System.out.println("2 - Action 2");
			System.out.println("3 - Action 3");
			System.out.println("4 - Action 4");
			System.out.println("");
		}
	}

	public void action1() {
		System.out.println("ACTION 1");
		if (gastarTokens(5)) {
			afegir_Michi(1);
			sumarMichis("michibi", 1);
			printGUI();
		} else {
			System.err.println("Michitokens Insuficients.");
		}
	}

	public void action2() {
		System.out.println("ACTION 2");

		if (gastarTokens(20)) {
			afegir_Michi(2);
			sumarMichis("michonk", 1);
			printGUI();
		} else {
			System.err.println("Michitokens Insuficients.");
		}
	}

	public void action3() {
		System.out.println("ACTION 3");

		if (gastarTokens(10)) {
			sumarMichis("michilover", 1);
			afegir_Michi(3);
			printGUI();
		} else {
			System.err.println("Michitokens Insuficients.");
		}
	}

	/**
	 * TODO hacer funcion entera
	 */
	public void action4() {
		System.out.println("ACTION 4");
		if (gastarTokens(100)) {
			sumarMichis("michismart", 1);
			afegir_Michi(4);
			
			printGUI();
		} else {
			System.err.println("Michitokens Insuficients.");
		}
	}

	public void quitGame() {
		executor.shutdown();
		executor.shutdownNow();
		synchronized (semafor_main) {
			semafor_main.notifyAll();
		}
	}

	public void afegir_Michi(int a) {
		synchronized (comprovator) {
			switch (a) {
			case 1:
				this.comprovator.add(this.executor.submit(new Michibi(this)));
			case 2:
				this.comprovator.add(this.executor.submit(new Michonk(this)));
			case 3:
				this.comprovator.add(this.executor.submit(new Michilover(this)));
			case 4:
				this.comprovator.add(this.executor.submit(new Michismart(this)));
			}
		}

	}

	public void incrementarMichiTokens(int tokens) {
		synchronized (michiSemaforo) {
			this.michiTokens += tokens;
		}
		printGUI();
	}

	public void sumarMichis(String name_michi, int a) {
		synchronized (michi_count) {
			michi_count.put(name_michi, michi_count.get(name_michi) + a);
		}
	}

	public boolean gastarTokens(int a) {
		synchronized (michiSemaforo) {
			if (michiTokens >= a) {
				michiTokens -= a;
				return true;
			}
			return false;
		}
	}
	public void Michismart(Michismart ms) throws InterruptedException{
		synchronized (notificar_smarts) {
			synchronized (comprovator) {
				if(notificar_smarts.size()>0) {
					comprovator.add(this.executor.submit(notificar_smarts.poll()));
				}
			}
		}
	}
	public void MichismartBegin() {
		
	}
	public void Michilover() throws InterruptedException {
		synchronized (michi_count) {
			if (michi_count.get("michilover") >= 5) {
				sumarMichis("michilover", -5);
				michi_count.notifyAll();
			}
			michi_count.wait();
		}
	}
} 
