package de.jdsr.java.exercise.geometrie;

public class Kreis extends EbenenFigur {

	private double radius;

	public Kreis(String bezeichnung, double r){
		super(bezeichnung);
		radius = r;
	}
	
	public void setRadius (double r){
		radius = r;
	}
	
	public double getRadius (){
		return radius;
	}
	
	public double getFlaeche (){
		return (Math.PI * Math.pow(getRadius(), 2));
	}
	
	public double getUmfang (){
		return (2 * Math.PI * getRadius());
	}

	@Override
	public String toString() {
		return "Kreis [radius=" + radius + ", bezeichnung=" + bezeichnung
				+ ", getFlaeche()=" + getFlaeche() + ", getRadius()="
				+ getRadius() + ", getUmfang()=" + getUmfang() + "]";
	}
	
}
