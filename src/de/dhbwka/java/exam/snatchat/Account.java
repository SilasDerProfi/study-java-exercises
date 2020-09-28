package de.dhbwka.java.exam.snatchat;

import java.awt.Color;

/**
 * Account
 */
public class Account {

	private String name;
	private State state = State.AVAILABLE;
	private Color color;

	public Account(String name) {
		this.name = name;
		color = new Color((int)(Math.random() * 201 - 1), (int)(Math.random() * 201), (int)(Math.random() * 201));
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}