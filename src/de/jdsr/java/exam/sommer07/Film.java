package de.jdsr.java.exam.sommer07;

public class Film extends Veranstaltung
{
	private String dieRegie;
	
	public Film(String name, String regie)
	{
		super(name);
		dieRegie = regie;
	}

	public String getTitel() 
	{
		return (getName() + ", Regie: " + dieRegie);
	}
}
