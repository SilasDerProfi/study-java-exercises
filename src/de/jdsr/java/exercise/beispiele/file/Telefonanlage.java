package de.jdsr.java.exercise.beispiele.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Telefonanlage {
	
		BufferedReader in;
		String[] strArray = new String[7];
		String nummer;
		int i = 0;
		
		Telefonanlage(String datei, String n)
		{
			nummer = n;
			try
			{
				in = new BufferedReader(new FileReader(datei));
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		
		public void rufnummerSuchenUndDatensaetzeAusgeben() throws IOException
		{
			String s;
			while((s = in.readLine()) != null )
			{
				strArray = s.split(Pattern.quote(";"));
				
				if(strArray[5].contains(nummer)){
					if( i == 0)
					{
						System.out.println("Zu untersuchende Nummer: " + nummer);
						System.out.println("Ergebnis");
						System.out.println("++++++++++++++++++++++++++++++++");
					}
					datensatzAusgeben();
					System.out.println("++++++++++++++++++++++++++++++++");
				}
			}
			System.out.println("Keine weiteren Datens�tze");
			in.close();
		}
		
		private void datensatzAusgeben()
		{
			System.out.println("Datensatz Nr.: " + ++i);
			System.out.println("Typ: " + strArray[0]);
			System.out.println("Datum: "  + strArray[1]);
			System.out.println("Name: " + strArray[2]);
			System.out.println("Rufnummer: "  + strArray[3]);
			System.out.println("Nebenstelle: "  + strArray[4]);
			System.out.println("Eigene Rufnummer: "  + strArray[5]);
			System.out.println("Dauer: "  + strArray[6]);
		}
}