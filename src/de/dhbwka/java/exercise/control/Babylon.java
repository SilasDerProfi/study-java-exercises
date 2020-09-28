
package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * Babylon
 */
public class Babylon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen: ");
        double a = sc.nextDouble();
        sc.close();
        double xn;

        for(xn = 1; Math.abs(CalcXn1(a, xn) - xn) > Math.pow(10, -6); xn = CalcXn1(a, xn)) {
            System.out.printf("xn: %f\r\n", xn);
        }

        System.out.printf("Die Wurzel aus %f ist %f\r\n", a, xn);
    }

    private static double CalcXn1(double a, double xn) {
        return ((a / xn) + xn) / 2;
    }
}