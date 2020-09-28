package de.jdsr.java.exam.winter17_18;

public abstract class Bauteil 
{
	protected int lang;
	protected int breit;
	protected int stark;
	
	@SuppressWarnings("unused")
	private int laengeGeleimteKante;
	@SuppressWarnings("unused")
	private boolean kanteGeleimt;
	
	public Bauteil()
	{
		
	}
	
	public Bauteil(int lang, int breit, int stark, int laengeGeleimteKante, boolean kanteGeleimt)
	{
		this.lang = lang;
		this.breit = breit;
		this.stark = stark;
		this.laengeGeleimteKante = laengeGeleimteKante;
		this.kanteGeleimt = kanteGeleimt;
	}
	
	public abstract int fertigen();
	public abstract boolean kontrolle();
}

