package de.dhbwka.theoinfo;

/**
 * DigitSum
 */
public class DigitSum {

    public static void main(String[] args) {
        System.out.print("Zahl zur Berechnung der rekursiven (heruntergebrochenen) Quersumme eingeben: ");
        System.out.println(digitSum(Integer.parseInt(System.console().readLine())));
    }

    static int digitSum(int i) {
        return i > 9 ? digitSum(i % 10 + i / 10) : i;
    }
}