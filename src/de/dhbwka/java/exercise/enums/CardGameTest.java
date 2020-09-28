package de.dhbwka.java.exercise.enums;

/**
 * TestGame
 */
public class CardGameTest {

    public static void main(String[] args) {
        CardGame g = new CardGame();
        g.shuffle();
        
        for(int i = 0; i < 10; i++)
        {
            PlayingCard c = g.get();
            System.out.println(c.compareTo(new PlayingCard(1, 0)));
            System.out.println(c);
        }

        System.out.println();
        g.sort();
        for(PlayingCard c : g.all())
            System.out.println(c);
    }
}