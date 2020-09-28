package de.dhbwka.java.exam.quartets;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Quartets Game
 */
public class Quartets {

	/**
	 * Card value types in order of the provided example data and cards.txt file (used in {@link #parseCard(String)})
	 */
	private final static Category[] CARD_TYPES = new Category[] { Category.EUROROUTE, Category.FREEWAY, Category.PIPELINE, Category.RAILS, Category.INTERNET, Category.INTERNET_MOBILE };

	/**
	 * Entry point of application
	 *
	 * @param args
	 *            command line arguments
	 */
	public static void main(final String[] args) {
		try {
			final List<Card> deck = Quartets.loadCards();
			final int sizePerPlayer = deck.size() / 2; // integer division takes care of odd deck sizes

			//final List<Category> categoryPool = new ArrayList(Arrays.asList(Category.values()));
			final List<Category> categoryPool = Arrays.asList(Category.values());

			final Game game = new Game(categoryPool, 5);
			final Player alex = new Player("Alex", new LinkedList<>(deck.subList(0, sizePerPlayer)));
			final Player andy = new Player("Andy", new LinkedList<>(deck.subList(sizePerPlayer, sizePerPlayer * 2)));

			game.registerClient1(new PlayerTerm(alex, game));
			game.registerClient2(new PlayerTerm(andy, game));

			game.start();
		} catch (final QuartetsException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Loads list of all available cards for the game
	 *
	 * @return list of available card for game
	 */
	private static List<Card> loadCards() {
		final List<Card> cards = new LinkedList<>();

		// START: replace this code

		try {

			for (final String example : java.nio.file.Files.readAllLines(Paths.get("io/cards.txt"))) {
				final Card card = Quartets.parseCard(example);
				if (card != null) {
					cards.add(card);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.shuffle(cards);
		// END: replace this code

		return cards;
	}

	/**
	 * Parse card instance
	 *
	 * @param line
	 *            line to parse
	 * @return parsed card instance
	 */
	private static Card parseCard(final String line) {
		try {
			final String[] lineData = line.split("[;]");
			final Card card = new Card(lineData[0]);
			for (int i = 0; i < Quartets.CARD_TYPES.length; i++) {
				card.setValue(Quartets.CARD_TYPES[i], Integer.parseInt(lineData[1 + i]));
			}
			return card;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
