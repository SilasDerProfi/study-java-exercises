package de.jdsr.java.exercise.beispiele.file;

import java.io.*;

public class Lesen
{

	public static void main(String[] args)
	{
		try
		{
			FileInputStream in = new FileInputStream("Lesen.java");
			int zeichen = 0;
			while(( zeichen = in.read()) != -1)
				System.out.print((char)zeichen);
			in.close();
		}
		catch( FileNotFoundException e)
		{
			System.out.print("Datei nicht gefunden: " +e.toString());
		}
		catch( IOException e)
		{
			System.out.println("Lesefehler ..." + e.toString());
		}
	}
}

