package de.dhbwka.java.exercise.operators;
import java.util.Scanner;
import java.util.*;
/**
 * Easter
 */
public class Easter {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Jahreszahl: ");
        int year = reader.nextInt();
        reader.close();

        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8*k + 13) / 25;
        int q = k / 4;            
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 *a + m) % 30;
        int e = (2*b + 4*c + 6*d + n) % 7;
        int easterOffset = (22 + d + e);

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("CEST")); 
        cal.set(year, 2,0);
        cal.add(Calendar.DATE, easterOffset);

        System.out.println(cal.getTime());
    }
}