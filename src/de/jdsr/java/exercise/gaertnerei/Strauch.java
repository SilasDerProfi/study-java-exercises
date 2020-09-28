package de.jdsr.java.exercise.gaertnerei;

public class Strauch extends Gehoelz{
	private boolean istGiftig;

	public Strauch(String art, int pflanzJahr, float preis, int h, boolean istGiftig){
		super(art, pflanzJahr, preis);
		this.istGiftig = istGiftig;
	}
	
	public boolean isIstGiftig() {
		return istGiftig;
	}

	public void setIstGiftig(boolean istGiftig) {
		this.istGiftig = istGiftig;
	}

	@Override
	public String toString() {
		return "Strauch [istGiftig=" + istGiftig + "]";
	}
	
}
