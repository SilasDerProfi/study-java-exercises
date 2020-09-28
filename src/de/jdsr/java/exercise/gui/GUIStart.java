package de.jdsr.java.exercise.gui;
import javax.swing.JOptionPane;

public class GUIStart
{
	public static void main(String[] args)
	{	
		Fenster f1 = new Fenster();
		
		f1.add(new Clientbereich());
		
		JOptionPane.showInputDialog("Bitte eine Eingabe machen, um das Fenster zu schlie�en.");
		f1.dispose();
	}
}
