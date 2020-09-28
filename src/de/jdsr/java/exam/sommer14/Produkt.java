package de.jdsr.java.exam.sommer14;

public abstract class Produkt {
	public static int anzahl = 0;
	public static int ausschuss = 0;
	protected String zustand = "";
	protected int produktNr = 0;
	protected String produktTyp = "";
	
	public String getZustand() {
		return zustand;
	}
	public void setZustand(String zust) {
		this.zustand = zust;
	}
	public int getProduktNr() {
		return produktNr;
	}
	public void setProduktNr(int nr) {
		this.produktNr = nr;
	}
	public String getProduktTyp() {
		return produktTyp;
	}
	public void setProduktTyp(String typ) {
		this.produktTyp = typ;
	}
	
	public abstract int pruefen();
}
