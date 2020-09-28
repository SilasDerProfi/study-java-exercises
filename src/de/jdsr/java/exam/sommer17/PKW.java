package de.jdsr.java.exam.sommer17;

import java.util.ArrayList;

public class PKW 
{
	
	private ArrayList<Buchung> ausleihDaten;
	@SuppressWarnings("unused")
	private int kategorie = 0;
	@SuppressWarnings("unused")
	private String modell = "";
	@SuppressWarnings("unused")
	private String farbe = "";
	@SuppressWarnings("unused")
	private int erstzulassungsJahr = 0;
	@SuppressWarnings("unused")
	private int kmStand = 0;
	
	public PKW(int kategorie, String modell, String farbe, int erstzulassungsJahr, int kmStand)
	{
		this.kategorie = kategorie;
		this.modell = modell;
		this.farbe = farbe;
		this.erstzulassungsJahr = erstzulassungsJahr;
		this.kmStand = kmStand;
		
		ausleihDaten = new ArrayList<Buchung>();
	}
	
	public boolean mieten(String ausleihDatum, String uhrzeit, String fahrer, int kmStand)
	{
		for(Buchung buchung  : ausleihDaten)
		{
			if(buchung.getAusleihDatum() == ausleihDatum && buchung.getUhrzeit() == uhrzeit)
				return false;
		}

		this.kmStand = kmStand;
		ausleihDaten.add(new Buchung(ausleihDatum, uhrzeit, fahrer));
		
		return true;
	}
	
}
