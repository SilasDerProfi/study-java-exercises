package de.jdsr.java.exam.sommer15;

public class Musikgruppe extends Kuenstlergruppe{
	private static double aktGemaPauschale;
	private double preisProStunde;
	private String musikStil;
	
	public Musikgruppe(String name, String stil, double preis) {
		super(name);
		musikStil = stil;
		preisProStunde = preis;
	}
	
	public static double getAktGemaPauschale() {
		return aktGemaPauschale;
	}

	public double getPreisProStunde() {
		return preisProStunde;
	}

	@Override
	public String getArt() {
		return "Musikgruppe " + musikStil;
	}

}
