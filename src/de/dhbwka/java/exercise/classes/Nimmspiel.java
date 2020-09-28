package de.dhbwka.java.exercise.classes;

/**
 * Nimmspiel
 */
public class Nimmspiel {

    private int desk1 = (int) (Math.random() * 10) + 1;
    private int desk2 = (int) (Math.random() * 10) + 1;
    private String player1;
    private String player2;
    private int turn = 1;

    public Nimmspiel(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Spieler " + player1 + " und " + player2 + ", Haufen 1: " + desk1 + " Kugel(n), Haufen 2: " + desk2 + " Kugeln");
    }

    public void Take(int deskNumber, int count) {
        switch (deskNumber) {
        case 1:
            if (count > 0 && count <= desk1) {
                desk1 -= count;
                turn++;
            } else
                System.out.println("Ungueltiger Spielzug");
            break;
        case 2:
            if (count > 0 && count <= desk2) {
                desk2 -= count;
                turn++;
            } else
                System.out.println("Ungueltiger Spielzug");
            break;
        }

        if (isWon()) {
            turn--;
            System.out.println("Spiel beendet.\r\n" + nextPlayer() + " hat gewonnen.");
        }
        else
        {
            System.out.println(this);
            System.out.println(nextPlayer() + " ist am Zug.");
        }
    }

    public String toString() {
        return "Tisch 1: " + desk1 + " Kugel(n). Tisch 2: " + desk2 + " Kugel(n).";
    }

    public boolean isWon()
    {
        return desk1 == 0 && desk2 == 0;
    }

    public String nextPlayer()
    {
        return (turn % 2 == 1) ? player1 : player2;
    }
}