package de.jdsr.java.exercise.mp3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadID3Tag {
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
        byte bTAG [] = new byte [3];
        byte bTitel [] = new byte [30];
        byte bInterpret [] = new byte [30];
        byte bCDTitel [] = new byte [30];
        byte bJahr [] = new byte [4];
        byte bKommentar [] = new byte [30];
        
        try
        {
            System.out.println("MP3-Datei: ");
            String filename = in.nextLine();
            FileInputStream fis = new FileInputStream(filename);
            long groesseMB3 = fis.available();
            //Datensatzzeiger positionieren
            fis.skip(groesseMB3-128);
            fis.read(bTAG);						//TAG lesen
            String strTAG = new String(bTAG);
            fis.read(bTitel);					//Titel lesen
            String strTitel = new String(bTitel);
            fis.read(bInterpret);				//Interpret lesen
            String strInterpret = new String(bInterpret);
            fis.read(bCDTitel);					//CDTietel lesen
            String strCDTitel = new String(bCDTitel);
            fis.read(bJahr);					//Jahr lesen
            String strJahr = new String(bJahr);
            fis.read(bKommentar);				//Kommentar lesen
            String strKommentar = new String(bKommentar);
            byte bGenre = (byte)fis.read();		//Genre lesen
            System.out.println("Dateigroesse: " + groesseMB3);
            System.out.println("Tag: " + strTAG);
            System.out.println("Titel: " + strTitel);
            System.out.println("Interpret: " + strInterpret);
            System.out.println("CD-Titel: " + strCDTitel);
            System.out.println("Jahr: " + strJahr);
            System.out.println("Kommentar: " + strKommentar);
            System.out.println("Genre: " + bGenre);
            fis.close();
        }
        catch (IOException err)
        {
            System.out.println("Fehler: " + err);
        }
        finally
        {
            in.close();	
        }
    }
}
