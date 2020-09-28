package de.jdsr.java.exam.winter17_18;

import java.util.ArrayList;

public class Regalschrank 
{
	private int anzahlBauteile;
	@SuppressWarnings("unused")
	private int anzahlFachboeden;
	@SuppressWarnings("unused")
	private boolean fertig;
	private ArrayList<Bauteil> Bauteile;
	
	public Regalschrank()
	{
		Bauteile = new ArrayList<Bauteil>();
	}
	
	public Regalschrank(int anzahlFachboeden, int anzahlBauteile)
	{
		Bauteile = new ArrayList<Bauteil>();
	}
	
	public boolean gesamtkontrolle()
	{
		for(Bauteil b : Bauteile)
			if(!b.kontrolle())
				return false;
		
		return true;
	}
	
	public boolean addBauteil(Bauteil neuesBauteil)
	{
		if(Bauteile.size() > anzahlBauteile)
		{
			Bauteile.add(neuesBauteil);
			return true;
		}
		else
		{
			return false;
		}
	}
}
