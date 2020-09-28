package de.jdsr.java.exam.sommer14;

public class Fenster extends Produkt{
	
	private String material = "";
	private int laenge = 0;
	private int breite = 0;
	private String verglasung = "";
	
	public Fenster(){
		
	}
	
	public Fenster(String mat, int l, int b, String glas){
		
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String mat) {
		this.material = mat;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int l) {
		this.laenge = l;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int b) {
		this.breite = b;
	}

	public String getVerglasung() {
		return verglasung;
	}

	public void setVerglasung(String glas) {
		this.verglasung = glas;
	}
	
	public int pruefen(){
		return 1;
	}
	
}
