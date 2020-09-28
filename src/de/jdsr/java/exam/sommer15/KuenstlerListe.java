package de.jdsr.java.exam.sommer15;

import java.util.ArrayList;

public class KuenstlerListe {
	private ArrayList<Kuenstlergruppe> gruppen;
	
	KuenstlerListe(){
		gruppen = new ArrayList<Kuenstlergruppe>();
	}
	
	public void hinzufuegen(Kuenstlergruppe gruppe){
		gruppen.add(gruppe);
	}

	public boolean entfernen(Kuenstlergruppe gruppe){
		return gruppen.remove(gruppe);
	}
	
	public Kuenstlergruppe get(int i){
		if(gruppen.size() > i && i >= 0)
			return gruppen.get(i);
		else
			return null;
	}

}
