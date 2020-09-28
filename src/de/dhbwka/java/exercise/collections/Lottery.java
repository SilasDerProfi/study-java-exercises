package de.dhbwka.java.exercise.collections;

import java.util.TreeSet;

/**
 * Lottery
 */
public class Lottery {

    public static void main(String[] args) {
        java.util.SortedSet<Integer> numbers = new TreeSet<Integer>();

        int superzahl = 0;
        while(numbers.size() < 7)
        {
            superzahl = (int)(Math.random() * 49) + 1;
            numbers.add(superzahl);
        }
        
        for(int i : numbers)
            if(i != superzahl)
                System.out.print(i + " ");

        System.out.print("Superzahl: " + superzahl);
        System.out.println();
    }
}