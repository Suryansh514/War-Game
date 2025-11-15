package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WarGame extends Game {

    private WarPlayer p1;
    private WarPlayer p2;
    private ArrayList<Card> deck = new ArrayList<>();

    public WarGame(String name, WarPlayer p1, WarPlayer p2) {
        super(name);
        this.p1 = p1;
        this.p2 = p2;

        buildDeck();
        Collections.shuffle(deck);
        dealCards();
    }

    private void buildDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                deck.add(new PlayingCard(suit, value));
            }
        }
    }

    private void dealCards() {
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0)
                p1.addCard(deck.get(i));
            else
                p2.addCard(deck.get(i));
        }
    }

    @Override
    public void play() {
        Scanner input = new Scanner(System.in);

        while (p1.hasCards() && p2.hasCards()) {

            System.out.println("\n=== NEW ROUND ===");
            System.out.println(p1.getName() + " has " + p1.getCardCount() + " cards.");
            System.out.println(p2.getName() + " has " + p2.getCardCount() + " cards.\n");

            // Player 1 flips
            System.out.println(p1.getName() + " press ENTER to flip your card.");
            input.nextLine();
            Card c1 = p1.drawCard();
            System.out.println(p1.getName() + " plays: " + c1);

            // Player 2 flips
            System.out.println("\n" + p2.getName() + " press ENTER to flip your card.");
            input.nextLine();
            Card c2 = p2.drawCard();
            System.out.println(p2.getName() + " plays: " + c2);

            int v1 = ((PlayingCard)c1).getValue();
            int v2 = ((PlayingCard)c2).getValue();

            if (v1 > v2) {
                System.out.println("\n" + p1.getName() + " wins the round!");
                p1.addCard(c1);
                p1.addCard(c2);
            }
            else if (v2 > v1) {
                System.out.println("\n" + p2.getName() + " wins the round!");
                p2.addCard(c1);
                p2.addCard(c2);
            }
            else {
                System.out.println("\nTie! Both players keep their cards.");
                p1.addCard(c1);
                p2.addCard(c2);
            }
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        System.out.println("\n=== GAME OVER ===");
        if (!p1.hasCards())
            System.out.println("Winner: " + p2.getName());
        else
            System.out.println("Winner: " + p1.getName());
    }
}
