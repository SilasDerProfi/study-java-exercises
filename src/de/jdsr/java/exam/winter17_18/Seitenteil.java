package de.jdsr.java.exam.winter17_18;

public class Seitenteil extends Bauteil
{
	@SuppressWarnings("unused")
	private boolean regalhalterbohrungen;
	@SuppressWarnings("unused")
	private boolean duebelbohrungen;
	
	public Seitenteil()
	{
		super();
	}
	
	public Seitenteil(int lang, int breit, int stark)
	{
		super(lang, breit, stark, 1, false);
		duebelbohrungen = false;
		regalhalterbohrungen = false;
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
