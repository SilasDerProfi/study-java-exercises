package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * Quadratics
 */
public class Quadratics {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("a: ");
        double a = reader.nextDouble();
        System.out.print("b: ");
        double b = reader.nextDouble();
        System.out.print("c: ");
        double c = reader.nextDouble();
        reader.close();
        double[] x = new double[2];

        if (a == 0) 
        {
            if (b != 0)
            {
                x[0] = -(c / b);
                System.out.printf("x: %f", x[0]);
            }
            else
            {
                System.out.println("Die Gleichung ist degeneriert");
            }

        }
        else if (a != 0)
        {
            double d = b * b - 4 * a * c;
            if (d >= 0) 
            {
                x[0] = (-b + Math.sqrt(d)) / (2*a);
                x[1] = (-b - Math.sqrt(d)) / (2*a);
                System.out.printf("x1: %f; x2: %f", x[0], x[1]);
            } 
            else
            {
                System.out.println("Die L\u00f6sung ist konjungiert und Komplex");
            }
        }
        System.out.println();
    }

}