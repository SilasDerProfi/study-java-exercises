package de.jdsr.java.exercise.interfaces;

import java.io.IOException;

public class KonsolenprogrammTest {
	
	public static void main(String[] args) throws IOException
	{
		Konsolenprogramm con = new Konsolenprogramm();
		
		con.ausgeben(con.eingeben());
	}

}
