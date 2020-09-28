package de.dhbwka.java.exercise.control;

import java.text.DecimalFormat;

/**
 * TemperatureTable
 */
public class TemperatureTable {

    public static void main(String[] args) {
        
    DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("Fahrenheit |    Celcius");
        System.out.print("-----------+-----------");
        for(int f = 0; f <= 300; f += 20)
        {
            double c = (5.0/9.0) * (f - 32);
            System.out.printf("\r\n%10d | %10s",f, df.format(c));
        }
        System.out.println();
    }
}