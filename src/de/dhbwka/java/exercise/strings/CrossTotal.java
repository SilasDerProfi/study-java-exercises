package de.dhbwka.java.exercise.strings;

/**
 * CrossTotal
 */
public class CrossTotal {

    public static void main(String[] args) {
        System.out.println("Bitte Zahl fuer Quersumme eingeben: ");
        String input = System.console().readLine();
        calcCrossTotal(input);
    }


    public static int calcCrossTotal(String input)
    {
        int crossTotal = 0;

        for (int i : input.toCharArray())
            crossTotal += i - '0';

        System.out.printf("Die Quersumme von %s ist %d\r\n", input, crossTotal);
        return crossTotal;
    }
}