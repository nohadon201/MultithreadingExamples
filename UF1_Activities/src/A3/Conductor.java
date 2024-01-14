package A3;

public class Conductor implements Runnable {
	private int tempo;
	public Conductor(int tempo, int nota) {
		super();
		this.tempo = (60000 / tempo) / nota;
	}

	@Override
	public void run() {
		
		try {
			while (true) {
				Thread.sleep(tempo);
				synchronized (this) {
					this.notifyAll();
				} 
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
