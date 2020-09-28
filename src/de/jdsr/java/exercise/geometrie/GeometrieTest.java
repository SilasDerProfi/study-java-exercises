package de.jdsr.java.exercise.geometrie;

// import java.util.ArrayList;

public class GeometrieTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		ArrayList<EbenenFigur> figurListe = new ArrayList<EbenenFigur>();
		
		//Dummy Daten
		//Dreieck
		Dreieck dreieckEins = new Dreieck("DreieckEins", 1, 1);
		Dreieck dreieckZwei = new Dreieck("DreieckZwei", 2, 2);
		
		//Rechteck
		Rechteck rechteckEins = new Rechteck("RechteckEins", 1, 1);
		Rechteck rechteckZwei = new Rechteck("RechteckZwei", 2, 2);

		//Kreis
		Kreis kreisEins = new Kreis("KreisEins", 1);
		Kreis kreisZwei = new Kreis("KreisZwei", 2);
		
		///Liste F�llen
		figurListe.add(dreieckEins);
		figurListe.add(dreieckZwei);
		figurListe.add(rechteckEins);
		figurListe.add(rechteckZwei);
		figurListe.add(kreisEins);
		figurListe.add(kreisZwei);
		
		
		for(EbenenFigur figur : figurListe){
			System.out.println(figur);
		}
		*/
		
		/*
		// 
		//ARRAY TEST
		// 
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(8);
		intList.add(7);
		*/
		
		
		Viereck v = new Viereck("DasIstMein4Eck", new Punkt(1.0, 1.0), new Punkt(2.0, 1.0), new Punkt(1.0, 2.0), new Punkt(2.0, 2.0));
		System.out.println(v);
		
	}

}
