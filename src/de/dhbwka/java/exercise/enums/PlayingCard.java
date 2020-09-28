package de.dhbwka.java.exercise.enums;

/**
 * PlayingCard
 */
public class PlayingCard implements Comparable<PlayingCard>{
    public enum Suit {DIAMONDS, HEART, SPADE, CLUBS };
    public enum CardValue {SEVEN, EIGHT, NINE, JACK, QUEEN, KING, TEN, ACE };
    
    private Suit suit;
    private CardValue cardValue;

    PlayingCard(int suit, int cardValue){
        this.suit = Suit.values()[suit];
        this.cardValue = CardValue.values()[cardValue];
    }

    public String getSuitText(){
        return suit.toString().charAt(0) + suit.toString().substring(1).toLowerCase();
    }

    public String getValueText(){
        return cardValue.toString().charAt(0) + cardValue.toString().substring(1).toLowerCase();
    }

    public Suit getSuit(){
        return suit;
    }

    public CardValue getValue(){
        return cardValue;
    }

    @Override
    public String toString(){
        return getSuitText() + " " +  getValueText();
    }

    @Override
    public int compareTo(PlayingCard o) {
        return (this.getSuit().ordinal() * 10) - (o.getSuit().ordinal() * 10) + this.getValue().ordinal() - o.getValue().ordinal();
        //return java.util.Comparator.comparing(PlayingCard::getSuit).thenComparing(PlayingCard::getValue).compare(this, o);
    }
}