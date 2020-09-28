package de.jdsr.java.exercise.beispiele.file;

import java.io.*;

public class FileWriterDemo
{

	public static void main(String[] args)
	{
		try
		{
			FileWriter fw = new FileWriter( "/home/michael/fileWriter.txt" );
			fw.write("yes we can!\n\tBarack Obama");
			fw.close();
		}
		catch( IOException e)
		{
			System.out.print("Dateifehler: " + e.toString());
		}
	}
}
