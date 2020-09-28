package de.jdsr.java.exam.sommer07;

import java.util.ArrayList;

public class Gast 
{
	Club derClub;
	ArrayList<Film> wunschFilm;
	ArrayList<Gruppe> wunschGruppe;
	private String derName;
	
	public Gast(String name, Club c)
	{
		derName = name;
		derClub = c;
		wunschFilm = new ArrayList<Film>();
		wunschGruppe = new ArrayList<Gruppe>();
	}

	public String getName()
	{
		return derName;
	}
}
