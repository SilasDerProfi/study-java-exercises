package de.jdsr.java.exam.sommer15;

import java.util.ArrayList;

public class AuftrittsListe {
	private ArrayList<KuenstlerAuftritt> auftritte;
	
	public AuftrittsListe(){
		auftritte = new ArrayList<KuenstlerAuftritt>();
	}
	
	public void hinzufuegen(String datum, String uhrzeit, String dauerInStunden, Kuenstlergruppe aufgetreteneGruppe){
		auftritte.add(new KuenstlerAuftritt(datum, uhrzeit, dauerInStunden, aufgetreteneGruppe));
	}

	public void entfernen(int index){
		auftritte.remove(index);
	}
	
	public KuenstlerAuftritt get(int i){
		if(auftritte.size() > i && i >= 0)
			return auftritte.get(i);
		else
			return null;
	}
}
