package de.jdsr.java.exercise.beispiele.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EinMalEins {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] horizontal = {1,2,3,4,5,6,7,8,9,10};
		int[] vertikal = {1,2,3,4,5,6,7,8,9,10};
		
		try
		{
			File f = new File("io/EinMalEins.csv");
			FileWriter fw = new FileWriter(f);
			
			for (int h = 0; h < horizontal.length; h++) 
			{
				String line = "";
				for (int v = 0; v < vertikal.length; v++) 
				{
					line += (horizontal[h] * vertikal[v]) + ";";
				}
				fw.write(line);
				fw.write("\r\n");
			}
			
			fw.close();
			System.out.println("Erfolgreich!");
			System.out.println("Datei: " + f.getAbsolutePath());
		}
		catch (IOException e)
		{
			System.out.println("Dateifehler " + e);
		}
		
	}

}
