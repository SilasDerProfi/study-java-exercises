package de.jdsr.java.exercise.gui;

import java.awt.Color;
import java.awt.Frame;

@SuppressWarnings("serial")
public class Fenster extends Frame{
	
	public Fenster()
	{
		setSize(900,900);
		setLocation(400,300);
		setBackground(Color.BLUE);
		setVisible(true);
	}

}
