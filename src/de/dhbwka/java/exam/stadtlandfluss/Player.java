package de.dhbwka.java.exam.stadtlandfluss;

public class Player {

	private String name;
	//private int allPoints;
	public Player(String string) {
		name = string;
	}


	@Override
	public String toString() {
		return name;
	}

}
