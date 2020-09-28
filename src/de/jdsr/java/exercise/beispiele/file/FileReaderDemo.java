package de.jdsr.java.exercise.beispiele.file;

import java.io.*;
public class FileReaderDemo
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader in = new BufferedReader( new FileReader("FileReaderDemo.java"));
			String str;
			while(( str = in.readLine()) != null )
				System.out.println(str);
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
	}
}
