package de.jdsr.java.exercise.geometrie;

public class Quader {
	private double seiteA;
	private double seiteB;
	private double seiteC;
	
	public Quader(double a, double b, double c){
		seiteA = a;
		seiteB = b;
		seiteC = c;
	}
	
	public void setSeiteA (double a){
		seiteA = a;
	}
	
	public void setSeiteB (double b){
		seiteA = b;
	}
	
	public void setSeiteC (double c){
		seiteA = c;
	}
	
	public double getSeiteA(){
		return seiteA;
	}
	
	public double getSeiteB(){
		return seiteB;
	}
	
	public double getSeiteC(){
		return seiteC;
	}
	
	public double getOberflaeche (){
		return (getSeiteA() * getSeiteB()) * 4 + (getSeiteA() * getSeiteC()) * 2;
	}
	
	public double getVolumen (){
		return getSeiteA() * getSeiteB() * getSeiteC();
	}
	
	public String toString(){
		return "Quader [" + seiteA + ", " + seiteB + ", " + seiteC + "]";
	}
}
