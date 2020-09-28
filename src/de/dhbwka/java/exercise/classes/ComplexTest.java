package de.dhbwka.java.exercise.classes;

import java.util.Arrays;
import java.util.Random;

/**
 * ComplexTest
 */
public class ComplexTest {

    public static void main(String[] args) {
        Complex comp1 = new Complex(1, 2);
        System.out.println("C1:     " + comp1);
        Complex comp2 = new Complex(2, 1);
        System.out.println("C2:     " + comp2);
        System.out.println("C1+C2:  " + comp1.add(comp2));
        System.out.println("C1-C2:  " + comp1.sub(comp2));
        System.out.println("C1*C2:  " + comp1.mult(comp2));
        System.out.println("C1/C2:  " + comp1.div(comp2));
        System.out.println("C1<C2:    " + comp1.isLess(comp2));

        Random r = new Random();
        Complex[] numbers = new Complex[10];

        System.out.println("Unsortiert:");
        for(int i =0; i < numbers.length; i++)
        {
            numbers[i] = new Complex(Math.round(r.nextDouble() * 1000) / 100., Math.round(r.nextDouble() * 1000) / 100.);
            System.out.println(numbers[i] + " Betrag: " + Math.round(numbers[i].getMagnitude() * 100) / 100.);
        }

        System.out.println("Sortiert:");
        Arrays.sort(numbers);
        for(Complex comp : numbers)
            System.out.println(comp + " Betrag: " + Math.round(comp.getMagnitude() * 100) / 100.);
    }
}