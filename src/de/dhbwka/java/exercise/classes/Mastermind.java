package de.dhbwka.java.exercise.classes;

import java.io.IOException;

/**
 * Mastermind
 */
public class Mastermind {

    private String combination = "";
    private String[] attempts;
    public int attemptCur;
    public int attemptMax = 20;

    Mastermind() {
        for (int i = 0; i < 5; i++) {
            combination += (char) ((int) (Math.random() * 8) + 'A');
        }
        attempts = new String[attemptMax];
        updateConsole();
    }
    
    void tipp(String s) {
        s = String.format("%5s", s).replace(' ', 'A').substring(0, 5).toUpperCase();
        String combination = this.combination;
        if (combination.equals(s)) {
            System.out.println("Gewonnen!");
            attemptCur = attemptMax;
            return;
        }
        attempts[attemptCur] = s;
        int correct = 0;
        int semiCorrect = 0;
        for (int i = 0; i < combination.length(); i++) {
            if (s.charAt(i) == combination.charAt(i))
                correct++;
            else
                for (int j = 0; j < combination.length(); j++)
                    if (s.charAt(i) == combination.charAt(j) && combination.charAt(j) != s.charAt(j)) {
                        combination = combination.substring(0, j) + "z" + combination.substring(j >= 5 ? j : j+1, 5);
                        s = s.substring(0, i) + "z" + s.substring(i >= 5 ? i : i+1, 5);
                        semiCorrect++;
                    }
        }
        attempts[attemptCur] += " " + correct + " " + semiCorrect;
        attemptCur++;
        updateConsole();
    }

    private void updateConsole() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Top-Secret: %s\r\n", combination);
        for (int i = 0; i < attempts.length; i++)
            if (attempts[i] != null)
                System.out.println((i + 1) + ". " + attempts[i]);
        System.out.println();
    }

    public boolean attemptsLeft() {
        return (attemptCur < attemptMax);
    }
}