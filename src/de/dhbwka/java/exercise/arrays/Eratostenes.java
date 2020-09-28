package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * Eratostenes
 */
public class Eratostenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maximum = sc.nextInt();
        sc.close();

        Integer[] sieve = new Integer[maximum - 1];
        for (int i = 0; i < sieve.length; sieve[i] = i++ + 2);

        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i] == null)
                continue;

            System.out.println(sieve[i]);

            int dividend = sieve[i];

            for (int j = i; j < sieve.length; j++)
                if (sieve[j] != null && sieve[j] % dividend == 0)
                    sieve[j] = null;
        }

    }
}