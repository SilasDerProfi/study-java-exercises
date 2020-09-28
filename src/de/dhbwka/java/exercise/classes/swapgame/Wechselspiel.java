package de.dhbwka.java.exercise.classes.swapgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Wechselspiel
 */
public class Wechselspiel {

    public static void main(String[] args) {

        if (args.length > 0 && args[0].toLowerCase() == "ui") {
        throw new UnsupportedOperationException("UI noch nicht implementiert");
        } else {
        startConsoleGame();
        }
    }

    private static void startConsoleGame() {
        Zeitnahme gameProcess = new Zeitnahme();

        try {
            // Aktion bei Timerintervall
            gameProcess.timeChange = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printConsoleGameState(gameProcess.getTurn(), gameProcess.getLevel(), gameProcess.getCountdown());
                }
            };

            // Aktion bei erhaltenen Punkten
            gameProcess.pointChange = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameProcess.pauseTimerOutput();
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (InterruptedException | IOException e1) {
                        e1.printStackTrace();
                    }

                    System.out.println(gameProcess.getMatch().toString());
                    printConsoleGameState(gameProcess.getTurn(), gameProcess.getLevel(), gameProcess.getCountdown());
                    gameProcess.resumeTimerOutput();
                }
            };

            gameProcess.startGame();

            while (gameProcess.isRunning) {
                String input = "";
                do {
                    input = JOptionPane.showInputDialog("Eingabe");
                    input = input == null ? "" : input.toUpperCase();
                    if (input.equals("STOP") || !gameProcess.isRunning) {
                        System.out.println();
                        return;
                    }

                } while (input.length() < 4
                        || gameProcess.getMatch().swap(new Position(input.charAt(0), (input.charAt(1) - 48)),
                                new Position(input.charAt(2), (int) (input.charAt(3) - 48))) == 0);
            }
        } finally {
            gameProcess.close();
        }
    }

    private static void printConsoleGameState(int turn, int level, int countdown) {
        System.out.printf("\rRunde %1s: Zug %2s von 10 (noch %3d Sekunde%s)", turn, level, countdown,
                countdown != 1 ? "n" : " ");
    }
}