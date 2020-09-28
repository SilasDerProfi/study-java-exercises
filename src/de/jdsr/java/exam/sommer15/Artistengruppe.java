package de.jdsr.java.exam.sommer15;

public class Artistengruppe extends Kuenstlergruppe{
	private double pauschalPreis;
	private String genre;
	
	public Artistengruppe(String name, String genre, double Preis) {
		super(name);
	    this.genre = genre;
	    pauschalPreis = Preis;
	}

	public double getPauschalPreis() {
		return pauschalPreis;
	}

	@Override
	public String getArt() {
		return genre;
	}

}
