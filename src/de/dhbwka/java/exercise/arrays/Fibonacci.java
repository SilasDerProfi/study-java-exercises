package de.dhbwka.java.exercise.arrays;

/**
 * Fibonacci
 */
public class Fibonacci {
    public static void main(String[] args) {
        
        int[] fibo = new int[20];

        fibo[0] = 1;
        fibo[1] = 1;

        for(int i = 2; i < fibo.length;i++)
        fibo[i] = fibo[i - 1] +  fibo[i - 2];

        for(int i : fibo) System.out.println(i);
    }
}