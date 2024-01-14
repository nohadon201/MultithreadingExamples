package ExamenDeVeritat;

public class Empleats {
	
	private Object semafor = new Object();
	
	private int alumnesAtesos;
	
	public Empleats() {
		this.alumnesAtesos=0;
	}
	public boolean Ocupats() {
		synchronized (semafor) {
			return this.alumnesAtesos>=2;
		}
	}
	public void sumarAlumneAtes(int a) {
		synchronized (semafor) {
			this.alumnesAtesos+=a;
		}
	}
}
