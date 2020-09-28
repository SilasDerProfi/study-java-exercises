package de.jdsr.java.exercise.geometrie;

public abstract class EbenenFigur {
	protected String bezeichnung;
	
	public EbenenFigur(String b){
		bezeichnung = b;
	}

	public abstract double getFlaeche ();
	
	public abstract double getUmfang ();
	
	@Override
	public String toString() {
		return "EbenenFigur [bezeichnung=" + bezeichnung + "]";
	}
}
