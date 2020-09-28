package de.dhbwka.java.exercise.classes;

/**
 * HornerTest
 */
public class HornerTest {

    public static void main(String[] args) {
        Horner h = new Horner(0.5, -3, 2, 4, 3, -10, 8, 4.5, 3, -2, 1);
        System.out.println("Polynomial f: " + h);
        System.out.println("f(1.5) =" + h.getValue(1.5));
    }
}