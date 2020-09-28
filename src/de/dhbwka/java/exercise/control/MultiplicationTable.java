package de.dhbwka.java.exercise.control;

/**
 * MultiplicationTable
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        for (int i = 10; i <= 109; System.out.printf("%6s", ++i % 10 == 0 ? i - 10 + "\n" : "\b" + i % 10 * (i / 10)));

        //for (int i = 11; i <= 110; System.out.printf("%" + (i % 10 == 0 ? 6 : 4) + "s", (i % 10 == 0) ? (i++ - 10) + "\r\n" : ((i % 10) * (i++ / 10))));
        //for (int i = 1; i <= 100; System.out.printf("%4d%s", (i % 10 == 1) ? (i / 10 + i % 10) : ((i % 10 == 0) ? (i) : ((i % 10) * (i / 10 + 1))), i++ % 10 == 0 ? "\r\n" : ""));
    }
}