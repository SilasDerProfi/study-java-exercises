package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * LeapYear
 */
public class LeapYear {

    public static void main(String[] args) {
        System.out.print("Welches Jahr soll gepr\u00fcft werden? ");
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        sc.close();

        if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0))
            System.out.println("Das Jahr ist ein Schaltjahr");
        else
            System.out.println("Das Jahr ist kein Schaltjahr");
    }
}