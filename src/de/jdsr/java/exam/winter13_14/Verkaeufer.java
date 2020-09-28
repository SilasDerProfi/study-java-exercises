package de.jdsr.java.exam.winter13_14;

public class Verkaeufer {
	
	public Artikel[] sortiment;
	
	Verkaeufer()
	{
		sortiment = new Artikel[100];
		for (int i = 0; i < sortiment.length; i++) {
			sortiment[i] =  new Artikel();
		}
	}
	
	public double getPreis(int i){
		return sortiment[i].getPreis();
	}
	
	public void setPreis(int i, double preis){
		sortiment[i].setPreis(preis);
	}
	
	public void kaufen(int i, int b){
		sortiment[i].kaufen(b);
	}
	
	public void rabatt(int s,  int d){
		for(Artikel a : sortiment){
			if(a.getBestand() > s)
				a.setPreis(a.getPreis() * ((100-d)/100));
		}
	}
	
	public void erweitereSortiment(int n){
		Artikel[] bisherigeArtikel = sortiment;
		sortiment = new Artikel[bisherigeArtikel.length + n];
		for (int i = 0; i < sortiment.length; i++){
			if(bisherigeArtikel.length > i)
				sortiment[i] = bisherigeArtikel[i];
			else
				sortiment[i] =  new Artikel();
		}
	}
}
