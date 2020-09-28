package de.dhbwka.java.exercise.enums;

import java.util.*;

/**
 * CardGame
 */
public class CardGame {

    private List<PlayingCard> cards;

    CardGame() {
        cards = new ArrayList<PlayingCard>();

        for(int i = 0; i < 8; i++)
        {
            cards.add(new PlayingCard(0, i));
            cards.add(new PlayingCard(1, i));
            cards.add(new PlayingCard(2, i));
            cards.add(new PlayingCard(3, i));
        }
    }
    void shuffle(){
        Collections.shuffle(cards);
    }

    void sort(){
        Collections.sort(cards);
    }

    PlayingCard get(){
        PlayingCard c = cards.get(0);
        cards.remove(0);
        return c;
    }
    List<PlayingCard> all(){
        return cards;
    }
}