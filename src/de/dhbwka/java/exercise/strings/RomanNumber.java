package de.dhbwka.java.exercise.strings;

/**
 * RomanNumber
 */
public class RomanNumber {

    public static void main(String[] args) {
        System.out.print("Bitte geben Sie eine roem. Zahl ein: ");
        int[] input = System.console().readLine().toUpperCase().chars().map(x -> charValue((char) x)).toArray();

        int decValue = input[input.length - 1];

        for (int i = 0; i < input.length - 1; i++)
            decValue += (input[i] < input[i + 1] ? -1 : 1) * input[i];

        System.out.println("Der Wert der Zahl ist " + decValue);
    }

    private static int charValue(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return 0;
        }
    }
}