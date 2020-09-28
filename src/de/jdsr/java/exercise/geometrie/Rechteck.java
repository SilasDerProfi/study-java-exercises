package de.jdsr.java.exercise.geometrie;

public class Rechteck extends EbenenFigur{
	private double laenge;
	private double breite;

	public Rechteck(String bezeichnung, double l, double b){
		super(bezeichnung);
		laenge = l;
		breite = b;
	}
	
	public double getFlaeche (){
		return laenge * breite;
	}
	
	public double getUmfang (){
		return (laenge + breite) * 2;
	}

	@Override
	public String toString() {
		return "Rechteck [breite=" + breite + ", laenge=" + laenge
				+ ", bezeichnung=" + bezeichnung + ", getFlaeche()="
				+ getFlaeche() + ", getUmfang()=" + getUmfang() + "]";
	}
	
}
