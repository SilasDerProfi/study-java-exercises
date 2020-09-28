package de.jdsr.java.exam.sommer16;

import java.util.ArrayList;

public class Bibliothek {
	private ArrayList<Leser> leserliste;
	@SuppressWarnings("unused")
	private ArrayList<Medium> medienliste;
	
	public int ermittleVormerkungen(int bibNr){
		int vormerkungsZaehler = 0;
		
		if(leserliste != null)
			for (Leser l : leserliste)
				for (Medium m : l.getVormerkliste())
					if(m.getBibNr() == bibNr)
						vormerkungsZaehler++;
		
		return vormerkungsZaehler;
	}
}
