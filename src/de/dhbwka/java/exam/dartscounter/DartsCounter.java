package de.dhbwka.java.exam.dartscounter;

public class DartsCounter {

	public static void main(String[] args) {
		new Game(new Board(), new Player[] { new Player("Michael van Gerwen"), new Player("Rob Cross") }).start();
	}
}
