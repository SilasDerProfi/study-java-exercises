package de.dhbwka.java.exercise.enums;

import java.util.Calendar;

/**
 * MonthsTest
 */
public class MonthsTest {

    public static void main(String[] args) {

        System.out.println(Months.values()[Calendar.getInstance().get(Calendar.MONTH)].getInformation());
    }
}