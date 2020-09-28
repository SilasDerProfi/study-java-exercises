package de.jdsr.java.exercise.interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Konsolenprogramm implements Ausgebbar, Eingebbar
{
	public void ausgeben(Object obj)
	{
		System.out.println("Inhalt: " + obj);
	}
	
	public Object eingeben() throws IOException
	{
		BufferedReader einlesen = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bitte eingeben (MIN " + MIN + ", MAX " + Eingebbar.MAX + " Buchstaben) : ");
		
		return einlesen.readLine();
	}
}
