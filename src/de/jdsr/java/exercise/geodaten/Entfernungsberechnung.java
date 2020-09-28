package de.jdsr.java.exercise.geodaten;

import java.util.ArrayList;
import java.util.Scanner;


public class Entfernungsberechnung {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Position> positionen = new ArrayList<Position>();
		System.out.println("Um die entfernungsberechnung durchzufuehren, schreiben sie ''Start''");
		
		for(int positionsCount = 1; positionsCount > 0; positionsCount++){
			
			System.out.println("Bitte geben Sie die Daten des " + positionsCount + ". Ortes ein");
			
			double gradLaenge;
			double minutenLaenge;
			double gradBreite;	
			double minutenBreite;
			
			try
			{
				System.out.println("L�ngengrad:");
				gradLaenge = sc.nextDouble();
				System.out.println("L�ngenminuten:");
				minutenLaenge = sc.nextDouble();
				System.out.println("Breitengrad:");
				gradBreite = sc.nextDouble();
				System.out.println("Breitenminuten:");
				minutenBreite = sc.nextDouble();
			}
			catch(java.util.InputMismatchException ex)
			{
				break;
			}
			
			positionen.add(new Position(gradLaenge, minutenLaenge, gradBreite, minutenBreite));
		}
		
		Result(positionen);
		sc.close();
	}
	
	private static void Result(ArrayList<Position> positionen)
	{
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("-----------------Ergebnisse-----------------");
		System.out.println("--------------------------------------------");
		System.out.println("Es wurden " + positionen.size() + " Positionen eingetragen.");
		
		double gesamtstrecke = 0;
		
		for(int i = 1; i < positionen.size(); i++){
			
			int currentPosIndex = i -1;
			int nextPosIndex = i;
			Position startPos = positionen.get(currentPosIndex);
			Position endPos = positionen.get(nextPosIndex);
			
			double dx = 71.5 * (startPos.GetGradBreiteKomplett() - endPos.GetGradBreiteKomplett());
			double dy = 111.3 * (startPos.GetGradLaengeKomplett() - endPos.GetGradLaengeKomplett());
			double entfernung =  Round(Math.sqrt(dx * dx + dy * dy), 2);
			
			System.out.println("Die Entfernung zwischen Position Nr." + (currentPosIndex + 1) + " und Position Nr." + 
					(nextPosIndex + 1) + " betr�gt " + entfernung + "km.");
			
			gesamtstrecke += entfernung;
		}
		
		System.out.println("Die gesamt zur�ckgelegte strecke betr�gt " + gesamtstrecke + "km.");
		
	}
	
	private static double Round(double value, int places) {
	    
		if (places < 0) throw new IllegalArgumentException();

	    long faktor = (long) Math.pow(10, places);
	    value = value * faktor;
	    long tmpValue = Math.round(value);
	    return (double) tmpValue / faktor;
	}
}
