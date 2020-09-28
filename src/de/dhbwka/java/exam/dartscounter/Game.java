package de.dhbwka.java.exam.dartscounter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Game
 */
public class Game {

    private Board board;
    private Player[] player;

    public Game(Board board, Player[] player) {
        this.board = board;
        this.player = player;
    }

    public void start() {
        int curPlayer = 0;

        while (!(Arrays.stream(player).anyMatch(p -> p.getRemainingPoints() == 0)
                || Arrays.stream(player).allMatch(p1 -> p1.getmadeVisitCount() == 10))) {

            System.out.println("Player " + player[curPlayer].getName() + ", " + player[curPlayer].getRemainingPoints()
                    + " point remaining.");

            if (player[curPlayer].getRemainingPoints() <= 170) {
                try {
                    List<String> fileLines = java.nio.file.Files
                            .readAllLines(Paths.get("io/checkouts.txt"));
                    String checkout = fileLines.get(player[curPlayer].getRemainingPoints() - 1);
                    if (!checkout.equals("-"))
                        System.out.println("Possible Checkout: " + checkout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.print("Enter visit: ");
            String input = System.console().readLine();

            int pointsBefore = player[curPlayer].getRemainingPoints();

            player[curPlayer].addVisit(
                    new Visit(Arrays.stream(input.split(" ")).map(a -> board.parseField(a)).toArray(Field[]::new)));
            System.out.println("scored: " + (pointsBefore - player[curPlayer].getRemainingPoints()));

            curPlayer = ++curPlayer >= player.length ? 0 : curPlayer;

            for (Player p : player)
                if (p.getRemainingPoints() == 0) {
                    System.out.println("Game shot and the leg, " + p.getName());
                    textFileOutput(p.getName(), p.getDartsThrown());
                    return;
                }
        }

        System.out.println("Abbruch wegen Wurfüberschreitung");
    }

    private void textFileOutput(String name, int dartsThrown) {
        try {
            try (FileWriter fw = new FileWriter("io/highscore.txt", true)) {
                fw.append(name + " won with " + dartsThrown + " darts\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}