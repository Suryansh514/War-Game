package ca.sheridancollege.project;

public class PlayingCard extends Card {

    private String suit;
    private int value; 

    public PlayingCard(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
