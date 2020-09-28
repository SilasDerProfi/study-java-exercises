package de.jdsr.java.exercise.geometrie;

public class Kugel {
	private double radius;
	
	public Kugel(double r){
		radius = r;	
	}
	
	public void setRadius (double r){
		radius = r;
	}
	
	public double getRadius (){
		return radius;
	}
	
	public double getOberflaeche (){
		return 4 * Math.PI * getRadius();
	}
	
	public double getVolumen (){
		return 4/3 * Math.PI * Math.pow(getRadius(), 3);
	}
	
	public String toString(){
		return "Kugel [" + radius + "]";
	}
}
