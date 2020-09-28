package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * DotProduct
 */
public class DotProduct {

    public static void main(String[] args) {

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] vector1 = readVector(sc, n, 'x');
        int[] vector2 = readVector(sc, n, 'y');
        sc.close();

        int dotProduct = 0;
        for(int i = 0; i < n; i++)
        {
            dotProduct += vector1[i] * vector2[i];
        }
        System.out.println("Das Skalarprodukt von x und y ist " + dotProduct);
    }

    private static int[] readVector(Scanner sc, int n, char name)
    {
        int[] vector = new int[n];

        for(int i = 0; i < vector.length; i++)
        {
            System.out.printf("Bitte %s_%d eingeben: ",name, i);
            vector[i] = sc.nextInt();
        }
        return vector;
    }

}