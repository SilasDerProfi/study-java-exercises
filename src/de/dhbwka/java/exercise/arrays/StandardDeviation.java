package de.dhbwka.java.exercise.arrays;

import java.util.*;
import java.util.stream.IntStream;

/**
 * StandardDeviation
 */
public class StandardDeviation {
    public static void main(String[] args) {

        int[] values = new int[100];
        Random r = new Random();

        for(int i = 0; i < values.length; i++)
            values[i] = r.nextInt(11);

        double avg =  (IntStream.of(values).sum() / (double)values.length);
        System.out.println("Mittelwert: " + avg);

        double standardDeviation = 0;

        for(int i = 0; i < values.length; i++)
             standardDeviation += Math.pow(values[i] - avg, 2);

        //System.out.println("Standardabweichung: " + Math.sqrt((1. / (values.length-1)) * standardDeviation));
        System.out.println("Standardabweichung: " + Math.sqrt(standardDeviation / (values.length-1)));

        System.out.println();
        System.out.println("Erneut ausf\u00fchren? (y)");
        if(System.console().readLine().toLowerCase().equals("y"))
            main(null);
    }
}