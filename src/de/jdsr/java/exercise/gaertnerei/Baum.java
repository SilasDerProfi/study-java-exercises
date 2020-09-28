package de.jdsr.java.exercise.gaertnerei;

public class Baum extends Gehoelz{
	private int maxHoehe;

	public Baum(String art, int pflanzJahr, float preis, int h){
		super(art, pflanzJahr, preis);
		maxHoehe = h;
	}
	
	public int getMaxHoehe() {
		return maxHoehe;
	}

	public void setMaxHoehe(int maxHoehe) {
		this.maxHoehe = maxHoehe;
	}

	@Override
	public String toString() {
		return "Baum [maxHoehe=" + maxHoehe + "]";
	}
	
}
