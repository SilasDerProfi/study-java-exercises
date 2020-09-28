package de.jdsr.java.exam.sommer07;

import java.util.ArrayList;

public class Club 
{
	ArrayList<Gast> derGast;
	ArrayList<Film> derFilm;
	ArrayList<Gruppe> dieGruppe;
	
	public Club()
	{
		derGast = new ArrayList<Gast>();
		derFilm = new ArrayList<Film>();
		dieGruppe = new ArrayList<Gruppe>();
	}
	
	
	public Film gibFilm(String name)
	{
		for(Film g : derFilm)
		{
			if(g.getName().equals(name))
				return g;
		}
		
		Film f = new Film(name, "");
		derFilm.add(f);
		return f;
	}
}
