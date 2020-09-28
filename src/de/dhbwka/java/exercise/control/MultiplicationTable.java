package de.dhbwka.java.exercise.control;

/**
 * MultiplicationTable
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        for (int i = 10; i <= 109; System.out.printf("%6s", ++i % 10 == 0 ? i - 10 + "\n" : "\b" + i % 10 * (i / 10)));
    }
}