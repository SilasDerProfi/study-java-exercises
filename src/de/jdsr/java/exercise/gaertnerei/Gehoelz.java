package de.jdsr.java.exercise.gaertnerei;

public abstract class Gehoelz {
	private String art;
	private int pflanzJahr;
	private float preis;
	
	public Gehoelz(String art, int pflanzJahr, float preis){
		this.art = art;
		this.pflanzJahr = pflanzJahr;
		this.preis = preis;
	}
	
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public int getPflanzJahr() {
		return pflanzJahr;
	}
	public void setPflanzJahr(int pflanzJahr) {
		this.pflanzJahr = pflanzJahr;
	}
	public float getPreis() {
		return preis;
	}
	public void setPreis(float preis) {
		this.preis = preis;
	}
	
	@Override
	public String toString() {
		return "Gehoelz [art=" + art + ", pflanzJahr=" + pflanzJahr
				+ ", preis=" + preis + "]";
	}
}
