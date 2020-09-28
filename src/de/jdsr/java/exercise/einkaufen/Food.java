package de.jdsr.java.exercise.einkaufen;

import java.text.DateFormat;

public class Food extends Goods {
	
	private DateFormat ablaufdatum;

	public DateFormat getAblaufdatum() {
		return ablaufdatum;
	}

	public void setAblaufdatum(DateFormat ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}
}
