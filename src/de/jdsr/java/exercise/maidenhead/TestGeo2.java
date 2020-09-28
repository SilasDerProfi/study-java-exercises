package de.jdsr.java.exercise.maidenhead;

import java.util.*;

public class TestGeo2 {
	
	public static void main(String[] args)  {
		String str;  //Eingabevariable
		Scanner input = new Scanner(System.in);

		Geo2 Geo = new Geo2();
		
		System.out.println("Maidenhead-Locator aus Laenge und Breite ");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.print("Laenge  in Grad.dezimalen (Oestl. Laenge negativ!)   : ");
		str = input.nextLine();
		double d_laenge = Double.parseDouble(str);
		System.out.print("Breite in Grad.dezimalen (Suedl. Breiten negativ!) : ");
		str = input.nextLine();
		double d_breite = Double.parseDouble(str);
		System.out.println(" ");
		
		Geo.locatorGGF(d_laenge, d_breite);
		Geo.locatorGF(d_laenge, d_breite);
		input.close();
	}

}
