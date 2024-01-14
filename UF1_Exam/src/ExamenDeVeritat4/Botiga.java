package ExamenDeVeritat4;

import java.util.HashMap;

public class Botiga {
	private Object semafor = new Object();
	
	private int alumnes_dints;
	
	private HashMap<String, Float> preus = new HashMap<>();
	
	private HashMap<String, Integer> quantitat = new HashMap<>();
	
	private Float DinersBotiga;
	
	private Object semafor2 = new Object();
	
	public Botiga() {
		this.alumnes_dints=0;
		this.DinersBotiga=0f;
		quantitat.put("Cafè", 10);
		quantitat.put("Croissant Nocilla", 3);
		quantitat.put("Entrepà vegetal", 3);
		quantitat.put("Perrillas", 2);
		preus.put("Cafè", 1.10f);
		preus.put("Croissant Nocilla", 1.50f);
		preus.put("Entrepà vegetal", 1.60f);
		preus.put("Perrillas", 1.00f);
	}
	
	public void print() {
		System.out.println("Preu Final: "+this.DinersBotiga);
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
	
	public void restarQuantitat(String name) {
		synchronized (quantitat) {
			this.quantitat.put(name, this.quantitat.get(name)-1);
		}
	}
	
	public void comprar(String name) {
		synchronized (preus) {
			synchronized (semafor2) {
				this.DinersBotiga+=this.preus.get(name);
				restarQuantitat(name);
				System.out.println(this.DinersBotiga);
			}
		}
	}
	
	public boolean existeixCosa(String name) {
		synchronized (quantitat) {
			return this.quantitat.get(name)>0;
		}
	}
}
