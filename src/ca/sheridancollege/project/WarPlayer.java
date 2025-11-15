package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarPlayer extends Player {

    private ArrayList<Card> hand = new ArrayList<>();

    public WarPlayer(String name) {
        super(name);
    }

    public void addCard(Card c) {
        hand.add(c);  
    }

    public Card drawCard() {
        if (hand.isEmpty()) {
            return null;
        }
        return hand.remove(0);
    }

    public int getCardCount() {
        return hand.size();
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    @Override
    public void play() {
       
    }
}
