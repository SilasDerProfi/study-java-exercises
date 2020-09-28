package de.jdsr.java.exercise.geodaten;

import java.util.Scanner;

public class MaidenheadLocator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			
			double gradLaenge;
			double minutenLaenge;
			double gradBreite;	
			double minutenBreite;
			
			try
			{
				System.out.println("L�ngengrad (�stl. L�ngen negativ):");
				gradLaenge = sc.nextDouble();
				System.out.println("L�ngenminuten:");
				minutenLaenge = sc.nextDouble();
				System.out.println("Breitengrad (S�dl. Breiten negativ):");
				gradBreite = sc.nextDouble();
				System.out.println("Breitenminuten:");
				minutenBreite = sc.nextDouble();
			}
			catch(java.util.InputMismatchException ex)
			{
				System.out.println("Falsche Eingabe.");
				return;
			}
			finally
			{
				sc.close();
			}
			
			String location = "";
			Position position = new Position(
											gradLaenge, 
											minutenLaenge, 
											gradBreite, 
											minutenBreite);
			
			location += GroesstfeldLaenge(position.GetGradLaengeKomplett());
			location += GroesstfeldBreite(position.GetGradBreiteKomplett());
			//location += GrossfeldLaenge(position.GetGradLaengeKomplett());
			//location += GrossfeldBreite(position.GetGradBreiteKomplett());
			
			System.out.println("Mainhead Location: " + location);
	}
	
	private static char GroesstfeldLaenge(double grad)
	{
		char[] positiveAlphabet = "IHGFEDCBA".toCharArray();
		char[] negativeAlphabet = "JKLMNOPQR".toCharArray();
		double letterIndex = grad / 18;
		if(letterIndex >= 0)
			return positiveAlphabet[(int)letterIndex];
		else
			return negativeAlphabet[-(int)letterIndex];
	}
	
	private static char GroesstfeldBreite(double grad)
	{
		//FALSCH
		char[] positiveAlphabet = "JKLMNOPQR".toCharArray();
		char[] negativeAlphabet = "IHGFEDCBA".toCharArray();
		double letterIndex = grad / 9;
		if(letterIndex >= 0)
			return positiveAlphabet[(int)letterIndex];
		else
			return negativeAlphabet[-(int)letterIndex];
	}
}