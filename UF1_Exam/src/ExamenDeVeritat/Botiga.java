package ExamenDeVeritat;

public class Botiga {
	private Object semafor = new Object();
	
	private int alumnes_dints;
	
	public Botiga() {
		this.alumnes_dints=0;
	}
	
	public boolean esperarFora() {
		synchronized (semafor) {
			return alumnes_dints>=4;
		}
	}
	public void sumarClient(int a) {
		synchronized (semafor) {
			this.alumnes_dints+=a;
		}
	}
}
