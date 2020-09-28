package de.jdsr.java.exam.sommer16;

import java.util.ArrayList;

public class Leser {
	@SuppressWarnings("unused")
	private int leserNr;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String vorname;
	private ArrayList<Medium> ausleihliste;
	private ArrayList<Medium> vormerkliste;
	
	public Leser(int nr, String name, String vorname){
		leserNr = nr;
		this.name = name;
		this.vorname = vorname;
		this.ausleihliste = new ArrayList<Medium>();
		this.vormerkliste = new ArrayList<Medium>();
	}

	public ArrayList<Medium> getAusleihliste() {
		return ausleihliste;
	}

	public ArrayList<Medium> getVormerkliste() {
		return vormerkliste;
	}
	
	public boolean hatAusgeliehen(int bibNr){
		if(ausleihliste != null){
			for (Medium m : ausleihliste) {
				if(m.getBibNr() == bibNr){
					return true;
				}
			}
		}
		return false;
	}
	
	
}
