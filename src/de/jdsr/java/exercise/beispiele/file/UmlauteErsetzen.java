package de.jdsr.java.exercise.beispiele.file;

import java.io.*;

public class UmlauteErsetzen {

	public static void ersetzen(String datei)
	{
		String content = "";
		try
		{
			BufferedReader in = new BufferedReader( new FileReader(datei));
			String str;
			while(( str = in.readLine()) != null )
				content += str;
			in.close();
		}
		catch( FileNotFoundException e)
		{
			System.out.print("Datei nicht gefunden: " + e.toString());
		}
		catch( IOException e )
		{
			System.out.print("Lesefehler... " + e.toString());
		}
		
		try
		{
			FileWriter fw = new FileWriter(datei);
			fw.write(content);
			fw.close();
		}
		catch( IOException e)
		{
			System.out.print("Dateifehler: " + e.toString());
		}
	}
}
