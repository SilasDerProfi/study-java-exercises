package de.jdsr.java.exam.winter17_18;

public class Fachboden extends Bauteil
{
	public Fachboden()
	{
		super();
	}
	
	public Fachboden(int lang, int breit, int stark)
	{
		super(lang, breit, stark, 1, false);
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
