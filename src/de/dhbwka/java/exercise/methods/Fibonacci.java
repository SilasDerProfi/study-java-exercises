package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

/**
 * Fibonacci
 */
public class Fibonacci {

    private static int[] numbers;

    public static void main(String[] args) 
    {
        System.out.print("Wie viele Fibonacci-Zahlen berechnen? ");
        Scanner sc = new Scanner(System.in);
        int lim = 0;

        do {
            lim = sc.nextInt();
        } while (lim < 1);
        sc.close();

        numbers = new int[lim];
        rec(0, lim);
        for (int i : numbers)
            System.out.println(i);
    }

    private static void rec(int i, int lim) 
    {
        if (i == 0) {
            numbers[0] = 1;
            numbers[1] = 1;
            rec(2, lim);
            return;
        } else if (i == lim)
            return;

        numbers[i] = numbers[i - 1] + numbers[i - 2];
        rec(++i, lim);

    }
}