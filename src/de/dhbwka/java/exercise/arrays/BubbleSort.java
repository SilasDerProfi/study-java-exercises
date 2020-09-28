package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int[] numbers = new int[sc.nextInt()];

        for(int i = 0; i < numbers.length; i++)
        {
            System.out.printf("Zahl %d eingeben: ", i + 1);
            numbers[i] = sc.nextInt();
        }
        sc.close();

        int a = 0;
        for (int i = 1; i < numbers.length; i++)
        {
            for (int j = 0; j < numbers.length - i; j++)
            {
                if (numbers[j] > numbers[j + 1])
                {
                    a = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = a;
                }

            }
        }

        System.out.print("Sortiert: ");
        for(int i : numbers)
            System.out.print(i + " ");

        System.out.println();
    }
}