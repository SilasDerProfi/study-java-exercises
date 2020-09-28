package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * Norm
 */
public class Norm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = sc.nextInt();

        double abs = 0;
        for(int i = 0; i < n; i++)
        {
            System.out.printf("Bitte x_%d eingeben: ", i);
            abs += Math.pow(sc.nextInt(), 2);
        }
        sc.close();

        abs = Math.sqrt(abs);
        System.out.println("Der Betrag von x ist " + abs);

    }
}