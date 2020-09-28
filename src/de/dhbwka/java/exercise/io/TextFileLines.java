package de.dhbwka.java.exercise.io;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * TextFileLines
 */
public class TextFileLines {

    private static final String path = "io/CrossTotal.txt";

    public static void main(String[] args) throws IOException {

        List<String> fileLines = java.nio.file.Files.readAllLines(Paths.get(path));

        if (fileLines.size() > 7)
            fileLines = fileLines.subList(1, 5);
        else
            return;

        for (String s : fileLines)
            System.out.println(s);

        System.out.print("Zeile 2-5: ");
        for (String s : fileLines)
            System.out.print(s);
        System.out.println();

    }
}