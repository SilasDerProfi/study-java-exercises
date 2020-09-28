package de.dhbwka.java.exercise.control;
import java.util.Scanner;

/**
 * AddUp
 */
public class AddUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0, next = 0;


        while(true)
        {
            System.out.print("Zahl eingeben (<0 f\u00fcr Abbruch): ");
            
            if((next = sc.nextInt())  < 0)
                break;
            
            result += next;
        }
        System.out.println(result);

        System.out.println("----------------------------------------");

        next = 0;
        result = 0;

        do{
             result += next;
             System.out.print("Zahl eingeben (<0 f\u00fcr Abbruch): ");
        }while((next = sc.nextInt()) >= 0);

        System.out.println(result);
        sc.close();
    }
}