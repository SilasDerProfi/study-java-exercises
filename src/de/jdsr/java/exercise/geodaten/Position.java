package de.jdsr.java.exercise.geodaten;

public class Position {
	
	
	private double GradLaenge;
	private double MinutenLaenge;
	private double GradBreite;
	private double MinutenBreite;
	
	public Position(double gradLaenge, double minutenLaenge, double gradBreite, double minutenBreite) {
		GradLaenge = gradLaenge;
		MinutenLaenge = minutenLaenge;
		GradBreite = gradBreite;
		MinutenBreite = minutenBreite;
	}
	
	public double GetGradLaengeKomplett(){
		return GradLaenge + (MinutenLaenge / 60);
	}
	
	public double GetGradBreiteKomplett(){
		return GradBreite + (MinutenBreite / 60);
	}
}
