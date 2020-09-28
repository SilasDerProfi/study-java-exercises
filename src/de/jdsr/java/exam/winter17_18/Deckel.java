package de.jdsr.java.exam.winter17_18;

public class Deckel extends Bauteil
{
	@SuppressWarnings("unused")
	private boolean duebelbohrungen;
	
	public Deckel()
	{
		super();
	}
	
	public Deckel(boolean duebelbohrungen)
	{
		super();
		this.duebelbohrungen = duebelbohrungen;
	}
	
	public int fertigen()
	{
		return 0;
	}
	
	public boolean kontrolle()
	{
		return false;
	}
}
