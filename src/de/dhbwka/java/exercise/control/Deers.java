package de.dhbwka.java.exercise.control;

/**
 * Deers
 */
public class Deers {

    public static void main(String[] args) {
        int deerCount = 200;

        for (int y = 1; deerCount < 300; y++) {
            deerCount = (int) (deerCount * 1.1 - 15);
            System.out.printf("%d: %d Hirsche\r\n", y, deerCount);
        }
    }
}