package de.jdsr.java.exercise.geometrie;

import java.util.Arrays;

public class Viereck {
	private  String bezeichnung;
	
	public Punkt[] punkte = new Punkt[4];

	Viereck(String bez, Punkt pktEins, Punkt pktZwei, Punkt pktDrei, Punkt pktVier){
		bezeichnung = bez;
		
		punkte[0] = pktEins;
		punkte[1] = pktZwei;
		punkte[2] = pktDrei;
		punkte[3] = pktVier;
	}
	
	Viereck(String bez, Punkt[] punktListe){
		bezeichnung = bez;
		if(punktListe.length == 4)
			punkte = punktListe;
	}

	@Override
	public String toString() {
		return "Viereck [bezeichnung=" + bezeichnung + ", punkte="
				+ Arrays.toString(punkte) + "]";
	}
}
