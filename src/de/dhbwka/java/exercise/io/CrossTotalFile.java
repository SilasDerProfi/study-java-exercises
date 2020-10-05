package de.dhbwka.java.exercise.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * PalindromeFile
 */
public class CrossTotalFile {

    private static final String PATH = "io/CrossTotal.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Bitte Zahl fuer Quersumme eingeben: ");
        String input = System.console().readLine();
        int crossTotal = de.dhbwka.java.exercise.strings.CrossTotal.calcCrossTotal(input);

        try (FileWriter fw = new FileWriter(PATH, true)) {
            fw.append("Quersumme von " + input + " ist " + crossTotal + "\r\n");
        }
    }
}