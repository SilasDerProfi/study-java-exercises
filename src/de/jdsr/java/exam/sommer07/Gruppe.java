package de.jdsr.java.exam.sommer07;

public class Gruppe extends Veranstaltung
{
	private String dasGenre;
	
	public Gruppe(String name, String genre)
	{
		super(name);
		dasGenre = genre;
	}
	
	public String getTitel()
	{
		return getName() + ", " + dasGenre;
	}
}
