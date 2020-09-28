package de.jdsr.java.exercise.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Clientbereich extends Canvas{
	@Override
	public void paint(Graphics g)
	{
		Image bild = getToolkit().getImage("C:/Users/schnursi/Desktop/sae.jpg");
		g.drawImage(bild, 300, 100, this);
		
		g.setColor(Color.BLACK);
	
		// Gesicht
		g.drawLine(20, 10, 60, 10);
		g.drawOval(15, 15, 50, 50);
		g.fillOval(20, 20, 40, 40);
		g.drawLine(80, 10, 120, 10);
		g.drawOval(75, 15, 50, 50);
		g.fillOval(80, 20, 40, 40);
		g.drawRect(65, 60, 10, 50);
		g.drawArc(20, 110, 100, 20, 170, 200);
		
		for (int i = 0; i < 5; i++) 
		{
			JOptionPane.showInputDialog(5 - i);
			g.fillOval((int)(Math.random() * 100), (int)(Math.random() * 100), (int)(Math.random() * 100), (int)(Math.random() * 100));
		}
	}
}
