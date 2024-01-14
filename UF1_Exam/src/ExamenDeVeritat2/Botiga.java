package ExamenDeVeritat2;

import java.util.HashMap;

public class Botiga {
	private Object semafor = new Object();
	
	private int alumnes_dints;
	
	private HashMap<String, Float> preus = new HashMap<>();
	
	
	private Float DinersBotiga;
	
	private Object semafor2 = new Object();
	
	public Botiga() {
		this.alumnes_dints=0;
		this.DinersBotiga=0f;
		preus.put("Cafè", 1.10f);
		preus.put("Croissant Nocilla", 1.50f);
		preus.put("Entrepà vegetal", 1.60f);
		preus.put("Perrillas", 1.00f);
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
	
	public void comprar(String name) {
		synchronized (preus) {
			synchronized (semafor2) {
				this.DinersBotiga+=this.preus.get(name);
				System.out.println(this.DinersBotiga);
			}
		}
	}
	
	public void print() {
		System.out.println("Preu Final: "+this.DinersBotiga);
	}
}
