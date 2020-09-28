package de.dhbwka.java.exercise.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * PalindromeFile
 */
public class PalindromeFile {

    private static final String PATH = "io/Palindrome.csv";

    public static void main(String[] args) throws IOException {

        String palindrome = de.dhbwka.java.exercise.strings.Palindrome.checkPalindrome();

        if (palindrome != null)
        {
            // selbst using ist in java kake
            try (FileWriter fw = new FileWriter(PATH, true)) {
                fw.append(palindrome + ",");
            }
        }
        
        String fileContent = new String(java.nio.file.Files.readAllBytes(Paths.get(PATH)));

        System.out.println("Alle bisher gefundenen Palindrome:");
        for (String pal : fileContent.split(","))
            System.out.println(pal);

    }
}