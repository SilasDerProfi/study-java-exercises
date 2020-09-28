package de.dhbwka.java.exam.quartets;

import java.util.LinkedList;

public class Player{

    private String name;
    private LinkedList<Card> cards;
	public Player(String name, LinkedList<Card>cards) {
        this.name = name;
        this.cards = cards;
	}

    /**
     * Fügt die übergebene Karte in die Datenstruktur hinzu
     */
    public void addCard(Card card){
        cards.add(card);
    }
    /**
     * Liefert true wenn mindestens 1 Karte in der Datenstruktur ist, sonst false
    */
    public boolean hasCards(){
        return cards.size() > 0;
    }

    /**
     * Liefert die oberste Karte sofern noch Karten vorhanden sind, sonst null
     */
    public Card getTopCard(){
        return cards.peek();
    }

    /**
     *  Liefert die oberste Karte sofern noch Karten vorhanden sind und entfernt
     */
    public Card drawTopCard(){
        return cards.pop();
    }

    public String getName() {
        return this.name;
    }
    
	public int getCardCount() {
		return cards.size();
	}

    @Override
    public String toString() {
        return name;
    }
}
