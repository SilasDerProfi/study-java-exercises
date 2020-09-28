package de.dhbwka.java.exercise.ui.paint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings("serial")
public class ElectionCanvas extends Canvas {

	private Color[] colors = { Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, Color.MAGENTA,
			Color.GREEN, Color.DARK_GRAY };

	private HashMap<String, Double> parties;

	public ElectionCanvas(HashMap<String, Double> parties) {
		this.parties = parties;
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(50, 125, 200));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(230, 230, 230));
		int linePos = (getHeight() - 70) / 4;
		g.drawLine(0, linePos, getWidth(), linePos);
		g.drawLine(0, linePos*2, getWidth(), linePos*2);
		g.drawLine(0, linePos*3, getWidth(), linePos*3);
		g.drawLine(0, linePos*4, getWidth(), linePos*4);
		g.fillRect(0, getHeight() - 20, getWidth(), getHeight() - 20);

		Double max = Collections.max(parties.values());
		int barWidth = getWidth() / parties.size() - 10;
		int maxBarSize = getHeight() - 50;

		List<String> nameList = new ArrayList<String>(parties.keySet());

		for (int i = 0; i < parties.size(); i++) {

			int x = i * barWidth + i * 10 + 5;
			int height = (int) ((maxBarSize / max) * parties.get(nameList.get(i)));
			int y = maxBarSize - height + 30;
			g.setColor(colors[i]);
			g.fillRect(x, y, barWidth, height);
			g.setColor(colors[0]);
			g.drawRect(x, y, barWidth, height);
			g.drawString(nameList.get(i) + " " + parties.get(nameList.get(i)) + "%", x + 5, getHeight() - 5);
		}
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, getHeight()-20, getWidth(), getHeight()-20);
	}
}
