package de.jdsr.java.exercise.geometrie;

public class Wuerfel {
	private double seiteA;
	
	Wuerfel(double a){
		seiteA = a;
	}
	
	public void setSeiteA(double a){
		seiteA = a;
	}
	
	public double getSeiteA(){
		return seiteA;
	}
	
	public double getOberflaeche (){
		return Math.pow(getSeiteA(), 2) * 6;
	}
	
	public double getVolumen (){
		return Math.pow(getSeiteA(), 3);
	}
	public String toString(){
		return "Wuerfel [" + seiteA + "]";
	}
}
