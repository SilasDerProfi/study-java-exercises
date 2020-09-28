package de.jdsr.java.exam.sommer15;

public abstract class Kuenstlergruppe {
	private String name;
	
	public Kuenstlergruppe(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public abstract String getArt();
}
