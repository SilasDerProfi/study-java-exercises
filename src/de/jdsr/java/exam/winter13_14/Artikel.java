package de.jdsr.java.exam.winter13_14;

public class Artikel {
	private String name;
	private String code;
	private int bestand;
	private double preis;
	
	Artikel(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String c) {
		this.code = c;
	}

	public int getBestand() {
		return bestand;
	}

	public void setBestand(int s) {
		this.bestand = s;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double p) {
		this.preis = p;
	}
	
	public void kaufen(int b) {
		 bestand += b;
	}
}
