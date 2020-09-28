package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

/**
 * Exponentiation
 */
public class Exponentiation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie bitte die Basis ein: ");
        double x = sc.nextDouble();
        System.out.println("Geben Sie bitte den positiven ganzzahligen Exponenten ein: ");
        int n = sc.nextInt();
        sc.close();
        System.out.println(x + "^" + n + " = " + xPowerN(x, n));
    }


    public static double xPowerN(double x,int n){
        return n > 1 ? x * xPowerN(x, n - 1) : x;
    }
}