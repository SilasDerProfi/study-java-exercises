package de.jdsr.java.exam.sommer07;

public abstract class Veranstaltung 
{
	private String derName;
	
	public Veranstaltung(String name)
	{
		derName = name;
	}
	
	public String getName()
	{
		return derName;
	}
	
	abstract public String getTitel();
}
