package de.jdsr.java.exercise.geometrie;

public class Dreieck extends EbenenFigur{
	private double grundseite;
	private double hoehe;

	public Dreieck(String bezeichnung, double g, double h){
		super(bezeichnung);
		grundseite = g;
		hoehe = h;
	}
	
	public double getFlaeche (){
		return ((grundseite * hoehe) / 2);
	}
	
	public double getUmfang (){
		return (Math.sqrt(Math.pow((grundseite / 2), 2) + Math.pow((hoehe / 2), 2)) * 2 + grundseite);
	}

	@Override
	public String toString() {
		return "Dreieck [grundseite=" + grundseite + ", hoehe=" + hoehe
				+ ", bezeichnung=" + bezeichnung + ", getFlaeche()="
				+ getFlaeche() + ", getUmfang()=" + getUmfang() + "]";
	}
	
}
