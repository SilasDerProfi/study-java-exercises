package de.jdsr.java.exercise.geometrie;

public class Punkt {
	private double x;
	private double y;
	
	Punkt(double xValue, double yValue){
		x = xValue;
		y = yValue;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Punkt [x=" + getX() + ", y=" + getY() + "]";
	}
}
