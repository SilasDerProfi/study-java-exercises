package de.dhbwka.java.exercise.classes;

/**
 * PolynomialTest
 */
public class PolynomialTest {

    public static void main(String[] args) {
        Polynomial pol1 = new Polynomial(2, 0, 0);
        Polynomial pol2 = new Polynomial(0, -4, 1);
        System.out.println("P1: " + pol1);
        System.out.println("P2: " + pol2);
        Polynomial pol3 = pol1.add(pol2);
        System.out.println("P3 = P1 + P2: " + pol3);
        Polynomial pol4 = pol3.multiply(2);
        System.out.println("P4 = 2.0 * P3: " + pol4);
        System.out.println("Nullstellen von P4 (" + pol4 + "):");
        for(double d : pol4.calculateZero())
            System.out.print(d + " ");
        System.out.println();
    }
}