package de.dhbwka.java.exercise.classes;

/**
 * NimmspielTest
 */
public class NimmspielTest {

    public static void main(String[] args) {

        System.out.println("Wie lautet der Name des ersten Spielers?");
        String player1 = System.console().readLine();
        System.out.println("Wie lautet der Name des zweiten Spielers?");
        String player2 = System.console().readLine();

        Nimmspiel game = new Nimmspiel(player1, player2);

        while(!game.isWon())
        {
            System.out.print("Spieler " + game.nextPlayer() + ": Von welchem Haufen ziehen Sie Kugeln?");
            int deskNumber = Integer.parseInt(System.console().readLine());
            System.out.print("Spieler " + game.nextPlayer() + ": Wieviele Kugeln ziehen Sie?");
            int count = Integer.parseInt(System.console().readLine());
            game.Take(deskNumber, count);
        }
    }
}