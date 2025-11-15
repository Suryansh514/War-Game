package ca.sheridancollege.project;

public class Main {
    public static void main(String[] args) {

        WarPlayer p1 = new WarPlayer("Player 1");
        WarPlayer p2 = new WarPlayer("Player 2");

        WarGame game = new WarGame("WAR", p1, p2);
        game.play();
    }
}
