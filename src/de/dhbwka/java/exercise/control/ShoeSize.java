package de.dhbwka.java.exercise.control;

import java.text.DecimalFormat;

/**
 * TemperatureTable
 */
public class ShoeSize {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Zentimeter    |  Gr\u00f6\u00dfe");
        System.out.print(  "--------------+-------");

        for(double cm = 19 + (1./3); cm <= 32 + (2./3); cm += 2./3)
            System.out.printf("\r\n%13s | %6s",df.format(cm) + " - " + df.format(cm + 2./3), (int)((cm + 2./3) * 1.5));

        System.out.println();
    }
}